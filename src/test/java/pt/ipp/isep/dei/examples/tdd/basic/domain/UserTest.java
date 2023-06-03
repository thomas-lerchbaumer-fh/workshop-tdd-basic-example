package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    /**
     * /US03. As a user when I add a duplicate<p>
     * <p>
     * bookmark, I want the system to increase the<p>
     * /rating of that bookmark, because no exact.<p>
     * Act: duplicates should exist.<p>
     */
    private User user;
    private Bookmark bookmark1;
    private Bookmark bookmark2;

    @BeforeEach
    void setUp() {
        user = new User("John");
        bookmark1 = new Bookmark("https://www.example1.com");
        bookmark2 = new Bookmark("https://www.example2.com");
    }

    @Test
    void testAddBookmark() {
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark2);

        List<Bookmark> expectedBookmarks = new ArrayList<>();
        expectedBookmarks.add(bookmark1);
        expectedBookmarks.add(bookmark2);

        assertEquals(expectedBookmarks, user.getBookmarks());
    }

    @Test
    void testRemoveBookmark() {
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark2);
        user.removeBookmark(bookmark1);

        List<Bookmark> expectedBookmarks = new ArrayList<>();
        expectedBookmarks.add(bookmark2);

        assertEquals(expectedBookmarks, user.getBookmarks());
    }

    @Test
    void testRemoveBookmarkWithNonExistingBookmark() {
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark2);
        Bookmark nonExistingBookmark = new Bookmark("https://www.example3.com");
        user.removeBookmark(nonExistingBookmark);

        List<Bookmark> expectedBookmarks = new ArrayList<>();
        expectedBookmarks.add(bookmark1);
        expectedBookmarks.add(bookmark2);

        assertEquals(expectedBookmarks, user.getBookmarks());
    }

    @Test
    public void checkDuplicateBookmarkIsRankingIncrease() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange

        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.google.com");
        user.addBookmark(bookmark);
        //Act
        user.addBookmark(bookmark1);

        //Assert
        assertEquals(1, user.getBookmarks().get(0).getRanking());
    }

    @Test
    public void checkDuplicateBookmarkIsDuplicate() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange

        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.google.com");
        //Act
        user.addBookmark(bookmark);

        //Assert
        assertTrue(user.isDuplicate(bookmark1));
    }

    @Test
    public void checkDuplicateBookmarkIsNoDuplicate(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange

        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.yahoo.com");
        //Act
        user.addBookmark(bookmark);
        //Assert
        assertFalse(user.isDuplicate(bookmark1));
    }

    @Test
    public void checkIfRatingDidNotManipulatedOtherEntries(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange

        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.yahoo.com");
        Bookmark bookmark3 = new Bookmark("https://www.yahoo.com");
        user.addBookmark(bookmark);
        user.addBookmark(bookmark1);
        //Act
        user.addBookmark(bookmark3);
        //Assert
        assertEquals(0,user.getBookmarks().get(0).getRanking());

    }

//US11. As a user I want to list my bookmarks
//sorted by rating (highest to smallest) - TL Homework

    @Test
    public void checkIfBookmarksAreSortedByRating() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange

        User user = new User("John");
        Bookmark bookmark1 = new Bookmark("https://www.google.com");
        Bookmark bookmark2 = new Bookmark("https://www.yahoo.com");
        Bookmark bookmark3 = new Bookmark("https://www.muugle.com");
        user.addBookmark(bookmark2);
        user.addBookmark(bookmark2);

        user.addBookmark(bookmark1);
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark1);
        //rating of 3

        //rating of 2
        user.addBookmark(bookmark3);
        //rating of 1

        List<Bookmark> expectedOrder = new ArrayList<>();
        expectedOrder.add(bookmark1);
        expectedOrder.add(bookmark2);
        expectedOrder.add(bookmark3);


        //Act
        List<Bookmark> sortedBookmarks = user.getBookmarksSortedByRating();
        //Assert
        assertEquals(expectedOrder, sortedBookmarks);
    }

    @Test
    public void checkIfDuplicatedRatingsAreSortedCorrectly(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange

        User user = new User("John");
        Bookmark bookmark1 = new Bookmark("https://www.google.com");
        Bookmark bookmark2 = new Bookmark("https://www.yahoo.com");
        Bookmark bookmark3 = new Bookmark("https://www.muugle.com");
        user.addBookmark(bookmark1);

        //rating of 3
        user.addBookmark(bookmark2);
        user.addBookmark(bookmark2);
        user.addBookmark(bookmark2);

        user.addBookmark(bookmark1);
        user.addBookmark(bookmark1);
        //rating of 3
        user.addBookmark(bookmark3);
        //rating of 1

        List<Bookmark> expectedOrder = new ArrayList<>();
        expectedOrder.add(bookmark1);
        expectedOrder.add(bookmark2);
        expectedOrder.add(bookmark3);


        //Act
        List<Bookmark> sortedBookmarks = user.getBookmarksSortedByRating();
        //Assert
        assertEquals(expectedOrder, sortedBookmarks);
    }

    @Test
    public void negativeCheckIfRatingsAreSorted(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark1 = new Bookmark("https://www.google.com");
        Bookmark bookmark2 = new Bookmark("https://www.yahoo.com");
        Bookmark bookmark3 = new Bookmark("https://www.muugle.com");
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark1);
        //rating of 3
        user.addBookmark(bookmark2);
        user.addBookmark(bookmark2);
        user.addBookmark(bookmark2);
        //rating of 3
        user.addBookmark(bookmark3);
        //rating of 1

        List<Bookmark> expectedOrder = new ArrayList<>();

        expectedOrder.add(bookmark2);
        expectedOrder.add(bookmark1);
        expectedOrder.add(bookmark3);


        //Act
        List<Bookmark> sortedBookmarks = user.getBookmarksSortedByRating();
        //Assert
        assertNotEquals(expectedOrder, sortedBookmarks);

    }

    @Test
    public void checkIfEmptyBookmarkListIsLeftUntouched(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        List<Bookmark> expectedOrder = new ArrayList<>();
        //Act
        List<Bookmark> sortedBookmarks = user.getBookmarksSortedByRating();
        //Assert
        assertEquals(expectedOrder, sortedBookmarks);

    }

}
