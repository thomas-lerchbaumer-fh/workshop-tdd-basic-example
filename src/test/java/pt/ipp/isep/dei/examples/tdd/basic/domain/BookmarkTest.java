package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals(result, true);

    }

    @Test
    public void test() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        //Arrange
        Bookmark bookmark = new Bookmark("https://www.google.com");
        //Act
        //boolean result = bookmark.isValidURL();
        //Assert
        assertTrue(true);

    }



}
