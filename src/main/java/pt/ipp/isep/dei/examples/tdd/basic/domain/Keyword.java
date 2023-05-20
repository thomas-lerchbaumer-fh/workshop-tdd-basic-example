package pt.ipp.isep.dei.examples.tdd.basic.domain;

public class Keyword {
    public String keyword;

    public Keyword(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword(){
        return this.keyword;
    }

    public Boolean isValidLength(){
        if(this.keyword.length() < 3){
            throw new IllegalArgumentException();
        }else
            return true;
    }
}
