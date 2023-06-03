package pt.ipp.isep.dei.examples.tdd.basic.domain;

public class Keyword {
    public String keyword;

    public Keyword(String keyword){
        if(this.isValidLength(keyword)) {
            this.keyword = keyword;
        }
    }

    public String getKeyword(){
        return this.keyword;
    }

    public Boolean isValidLength(String keyword){
        if(keyword.length() < 3){
            throw new IllegalArgumentException();
        }else
            return true;
    }
}
