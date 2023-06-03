package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public void removeBookmark(Bookmark bookmark) {
        this.bookmarks.remove(bookmark);
    }

    public List<Bookmark> getBookmarks(){
        return this.bookmarks;
    }


    public List<Bookmark> filterByKeyword(String tag){
        List<Bookmark> bookmarksByTag = new ArrayList<>();
        for (Bookmark bookmark : this.bookmarks) {
            for (Keyword keyword : bookmark.tags) {
                if (keyword.keyword.equals(tag)) {
                    bookmarksByTag.add(bookmark);
                }
            }
        }
        return bookmarksByTag;
    }


    public List<Bookmark> filterByKeyword(List<String> tags){
        List<Bookmark> bookmarksByTag = new ArrayList<>();
        bookmarksByTag = this.bookmarks.stream().filter(bookmark -> bookmark.tags.stream().map(Keyword::getKeyword).anyMatch(tags::contains)).collect(Collectors.toList());
        return bookmarksByTag;

    }

    public List<Bookmark> getBookmarksSortedByRating(){
        List<Bookmark> bookmarksByRanking = new ArrayList<>();
        bookmarksByRanking = this.bookmarks.stream().sorted((o1, o2) -> o2.getRanking().compareTo(o1.getRanking())).collect(Collectors.toList());
        return bookmarksByRanking;
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
