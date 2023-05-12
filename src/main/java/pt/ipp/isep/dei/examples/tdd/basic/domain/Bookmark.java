package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class Bookmark {
    String url;
    List<Keyword> tags;


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


}
