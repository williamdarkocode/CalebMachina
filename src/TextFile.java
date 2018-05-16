import java.util.*;
public class TextFile extends DataItem{
    private String name;
    private String description;
    private int count;
    private String author;
    private String title;
    private String content;
    public TextFile(String name, String description, int count,String author, String title, String content) {
        super(name, description, count);
        this.author = author;
        this.title = title; 
        this.content = content;
        
    }
    
    public String getText() {
        String txt = "";
        txt+="              "+author;
        txt+="\n" + "                               "+ title;
        txt+="\n"+ "                "+content;
        return txt;
    }
    
    public void setTitle(String s) {
        this.title = s;
    }
    
    public void setAuthor(String s) {
        this.author = s;
    }
    
    public void setContent (String s) {
        this.content = s;
    }
    
    public String toString() {
        return getText();
    }
    
    
}