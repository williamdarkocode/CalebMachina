import java.util.*;
public class Node<T> {
    private List<Node> children;
    private Node parent = null;
    private T data = null;
    private String name = null;
    private CMD cmd;
    
    public Node(T data) {
        this.children = new ArrayList<>();
        this.data = data;
        cmd = new CMD();
    }
    
    public Node(T data, String name) {
        this.children = new ArrayList<>();
        this.data = data;
        this.name = name;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public Node getParent() {
        return this.parent;
    }
    
    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }
    
    public void addChild(T data) {
        Node<T> child = new Node<>(data);
        child.setParent(this);
        this.children.add(child);
    }
    
    public void addChild(Node child, String name) {
        child.setParent(this);
        child.setName(name);
        this.children.add(child);
    }
    
    public void addChild(T data, String name) {
        Node<T> child = new Node<>(data);
        child.setParent(this);
        child.setName(name);
        this.children.add(child);
    }
    
    public void addChildren(List<Node> kiddies) {
        for(Node n: kiddies) {
            n.setParent(this);
        }
        this.children.addAll(kiddies);
    }
    
    public void addChildren(Map<String, T> littleKiddies) {
        List<Node> littleBabies = new ArrayList<>();
        for(String n: littleKiddies.keySet()) {
            Node<T> child = new Node<>(littleKiddies.get(n), n);
            child.setParent(this);
            littleBabies.add(child);
        }
        this.children.addAll(littleBabies);
    }
    
    public List<Node> getChildren() {
        return this.children;
    }
    
    public Node getChild(int idx){ 
        return this.children.get(idx);
    }
    
    public boolean hasChildren() {
        return this.children.size() > 0;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public void setName(String s){
        this.name = s;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String preOrder(Node tree){
        String s = "";
        
        return s;
    }
    
    
    public String toString(){
        String str = ""+ "NAME: " + this.name;
        str+= this.data.toString() + "\n";
        for(Node n: this.children){
            str+=n.toString() + "\n";
        }
        return str;
    }
    
    public static void main(String[] args){
        DataItem d = new DataItem("File", "Test Data Item Node", 1);
        DataItem d1 = new DataItem("File 1", "Second test Item (Child)", 1);
        DataItem d2 = new DataItem("File 2", "Third test Item (Child)", 1);
        DataItem d3 = new DataItem("File 2", "Third test Item (Child)", 1);
        
        Node n = new Node<>(d);
        n.setName("NODE 1 (parent)");
        n.addChild(d1, "Child second file");
        n.addChild(d2, "Child third file");
        n.addChild(d3, "Child third file");
        
        Node m = new Node<>(d, "Node 2 (parent)");

        System.out.println(n.toString());
        
        System.out.println(m.toString());
    }
}