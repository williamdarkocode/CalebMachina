import java.util.*;

public class Folder<T> extends Node<T>{
    
    public Folder(T data, String name){
        super(data, name);
    }
    
    public Folder(T data){
        super(data);
    }
    
}