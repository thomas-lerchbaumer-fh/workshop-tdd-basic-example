package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    List<Bookmark> bookmarks = new ArrayList<>();


    public User(String name) {
        this.name = name;
    }

    public void addBookmark(Bookmark bookmark) {
           if (bookmark.isValidURL()){
               if(this.checkForDuplicates(bookmark)){
                   this.bookmarks.add(bookmark);
               }

           }
    }

    public List<Bookmark> getBookmarks(){
        return this.bookmarks;
    }

    public boolean checkForDuplicates(Bookmark bookmark){
        for (Bookmark value : bookmarks) {
            if (value.url.equals(bookmark.url)) {
                value.setRanking();
                return false;
            }
        }
        return true;
    }

}
