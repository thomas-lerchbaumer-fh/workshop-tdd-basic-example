package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    List<Bookmark> bookmarks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addBookmark(Bookmark bookmark) {
           if (bookmark.isValidURL()) this.bookmarks.add(bookmark);
    }

    public List<Bookmark> getBookmarks(){
        return this.bookmarks;
    }

}
