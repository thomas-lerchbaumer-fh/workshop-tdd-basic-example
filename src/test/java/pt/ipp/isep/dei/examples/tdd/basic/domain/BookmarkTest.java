package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;
import java.net.MalformedURLException;

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
        //Bookmark keyword = new Bookmark.keyword();

        //addcomment
        //Act
        assertTrue(result);

    }

}

