package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    /**
     * /US03. As a user when I add a duplicate<p>
     * <p>
     * bookmark, I want the system to increase the<p>
     * /rating of that bookmark, because no exact.<p>
     * Act: duplicates should exist.<p>
     */
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

}
