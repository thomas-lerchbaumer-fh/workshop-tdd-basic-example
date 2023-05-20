package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {



    /**
     * Create a valid bookmark<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void checkBookmarkForValidFormat() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        Bookmark bookmark = new Bookmark("https://www.google.com");
        //Act
        boolean result = bookmark.isValidURL();
        //Assert
        assertTrue(result);

    }

    @Test
    public void checkNonValidURL() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        Bookmark bookmark = new Bookmark("Invalid URL");
        //Act
        boolean result = bookmark.isValidURL();
        //Assert
        assertFalse(result);
    }

    @Test
    public void addValidBookmarkToUser() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange

        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");

        //Act
        user.addBookmark(bookmark);
        //Assert
        assertEquals(1, user.getBookmarks().size());
    }


   @Test
    public void addInvalidBookmarkToUser(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("Invalid Url");
        //Act
        user.addBookmark(bookmark);
        //Assert
        assertEquals(0, user.getBookmarks().size());
    }

    @Test
    public void addMultipleValidBookmarksToUser(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.youtube.com");
        Bookmark bookmark1 = new Bookmark("https://www.google.com");
        //Act
        user.addBookmark(bookmark);
        user.addBookmark(bookmark1);
        //Assert
        assertEquals(2, user.getBookmarks().size());
    }

    @Test
    public void checkKeywordLength() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        Keyword keyword = new Keyword("google");
        boolean result = keyword.isValidLength();
        //Bookmark keyword = new Bookmark.keyword();

        //Act
        assertTrue(result);

    }
    @Test
    public void checkKeywordLengthBelowThree() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        //Act
        assertThrows(IllegalArgumentException.class,()->{
            Keyword key = new Keyword("ie");
            key.isValidLength();
        });

    }
    @Test
    public void checkKeywordLengthExactThree() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        Keyword keyword = new Keyword("eis");
        boolean result = keyword.isValidLength();

        //Act
        assertTrue(result);

    }
    @Test
    public void checkTagtoUrlPossible() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        Bookmark bookmark = new Bookmark("https://google.com");
        Keyword keyword = new Keyword("google");
        bookmark.addTag(keyword);

        //Act
        assertEquals(1,bookmark.tags.size());

    }


    //US03. As a user when I add a duplicate
    //bookmark, I want the system to increase the
    //rating of that bookmark, because no exact
    //duplicates should exist

    //US06. As a user I want to be able to filter
    //bookmarks by one keyword -- by TL (Homework)

    @Test
    public void testIfBookmarkIsReturnedWhenSearchingViaTag(){
        System.out.println("\t\tExecuting " + new Object(){}.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Keyword keyword = new Keyword("keyword");
        user.addBookmark(bookmark);
        bookmark.addTag(keyword);
        //Act
        List<Bookmark> result = user.filterByKeyword("keyword");

        //Assert
        assertEquals(1, result.size());
    }

    @Test
    public void noBookmarkShouldBeReturned(){
        System.out.println("\t\tExecuting " + new Object(){}.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Keyword keyword = new Keyword("keyword");
        user.addBookmark(bookmark);
        bookmark.addTag(keyword);
        //Act
        List<Bookmark> result = user.filterByKeyword("keyword1");

        //Assert
        assertEquals(0, result.size());
    }

    @Test
    public void multipleBookmarksShouldBeReturned(){
        System.out.println("\t\tExecuting " + new Object(){}.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.yahoo.com");
        Bookmark bookmark2 = new Bookmark("https://www.muugle.com");
        Keyword keyword = new Keyword("keyword");
        user.addBookmark(bookmark);
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark2);
        bookmark.addTag(keyword);
        bookmark1.addTag(keyword);
        bookmark2.addTag(keyword);
        //Act
        List<Bookmark> result = user.filterByKeyword("keyword");

        //Assert
        assertEquals(3, result.size());
    }

    @Test
    public void checkIfFilteringByTagIsCaseSensitive(){
        System.out.println("\t\tExecuting " + new Object(){}.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.yahoo.com");
        Bookmark bookmark2 = new Bookmark("https://www.muugle.com");
        Keyword keyword = new Keyword("keyword");
        user.addBookmark(bookmark);
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark2);
        bookmark.addTag(keyword);
        bookmark1.addTag(keyword);
        bookmark2.addTag(keyword);
        //Act
        List<Bookmark> result = user.filterByKeyword("KEYWORD");

        //Assert
        assertEquals(0, result.size());
    }

    //• US07. As a user I want to be able to filter
    //bookmarks by one or more keywords -- by TL (Homework)

    @Test
    public void tagsMatchMultipleBookmarks(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.yahoo.com");
        Keyword keyword = new Keyword("keyword");
        Keyword keyword1 = new Keyword("keyword1");
        user.addBookmark(bookmark);
        user.addBookmark(bookmark1);
        bookmark.addTag(keyword);
        bookmark1.addTag(keyword1);
        List<String> searchKeywords = new ArrayList<>();
        searchKeywords.add("keyword");
        searchKeywords.add("keyword1");

        //Act
        List<Bookmark> result = user.filterByKeywords(searchKeywords);
        //Assert
        assertEquals(2, result.size());
    }

    @Test
    public void tagsMatchSingleBookmark(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.yahoo.com");
        Keyword keyword = new Keyword("keyword");
        Keyword keyword1 = new Keyword("keyword1");
        user.addBookmark(bookmark);
        user.addBookmark(bookmark1);
        bookmark.addTag(keyword);
        bookmark1.addTag(keyword1);
        List<String> searchKeywords = new ArrayList<>();
        searchKeywords.add("keyword");
        searchKeywords.add("keyword3");

        //Act
        List<Bookmark> result = user.filterByKeywords(searchKeywords);
        //Assert
        assertEquals(1, result.size());
    }

    @Test
    public void tagsMatchNoBookmark(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        User user = new User("John");
        Bookmark bookmark = new Bookmark("https://www.google.com");
        Bookmark bookmark1 = new Bookmark("https://www.yahoo.com");
        Keyword keyword = new Keyword("keyword");
        Keyword keyword1 = new Keyword("keyword1");
        user.addBookmark(bookmark);
        user.addBookmark(bookmark1);
        bookmark.addTag(keyword);
        bookmark1.addTag(keyword1);
        List<String> searchKeywords = new ArrayList<>();
        searchKeywords.add("keyword3");
        searchKeywords.add("keyword4");

        //Act
        List<Bookmark> result = user.filterByKeywords(searchKeywords);
        //Assert
        assertEquals(0, result.size());
    }

}

