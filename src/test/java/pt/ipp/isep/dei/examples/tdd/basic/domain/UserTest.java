package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {


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

}
