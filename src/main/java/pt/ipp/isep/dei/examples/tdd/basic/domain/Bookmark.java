package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.awt.print.Book;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bookmark {
    String url;
    List<Keyword> tags = new ArrayList<Keyword>();
    Integer ranking = 0;
    LocalDateTime createdAt;


    public Integer getRanking() {
        return this.ranking;
    }

    public void setRanking(){
        this.ranking = this.ranking + 1;
    }

    public Bookmark(String url) {
        this.url = url;
    }

    public boolean isValidURL() {
        try {
            new URL(this.url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public void addTag(Keyword keyword){
            this.tags.add(keyword);
    }

    public void removeTag(Keyword keyword) {
        this.tags.remove(keyword);
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }


}
