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
           if (bookmark.isValidURL()){
               if(!this.isDuplicate(bookmark)){
                   this.bookmarks.add(bookmark);
                   //
               }

           }
    }

    public List<Bookmark> getBookmarks(){
        return this.bookmarks;
    }


    public List<Bookmark> filterByKeyword(String tag){
        List<Bookmark> bookmarksByTag = new ArrayList<>();
        for (Bookmark value : this.bookmarks) {
            for (Keyword keyword : value.tags) {
                if (keyword.keyword.equals(tag)) {
                    bookmarksByTag.add(value);
                }
            }
        }
        return bookmarksByTag;
    }
    public boolean isDuplicate(Bookmark bookmark){
        for (Bookmark value : bookmarks) {
            if (value.url.equals(bookmark.url)) {
                value.setRanking();
                return true;
            }
        }
        return false;
    }

}
