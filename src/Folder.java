import java.util.*;

public class Folder extends Node{
    private String name;
    private CMD cmd;
    public Folder(String name) {
        super(name);
        this.name = name;
        cmd = new CMD();
    }
    
    public Folder(String name, Map<String, DataItem> littleKiddies){
        super(name);
        this.name = name;
        addChildren(littleKiddies);
    }
    
    
    
}