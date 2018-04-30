import java.util.*;
public class Node<T> {
    private List<Node<T>> children;
    //private List<T> childs;
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

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return this.parent;
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child, String name) {
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

    public void addChildren(List<Node<T>> kiddies) {
        for(Node n: kiddies) {
            n.setParent(this);
        }
        this.children.addAll(kiddies);
    }

    public void addChildren(Map<String, T> littleKiddies) {
        List<Node<T>> littleBabies = new ArrayList<>();
        for(String n: littleKiddies.keySet()) {
            Node<T> child = new Node<>(littleKiddies.get(n), n);
            child.setParent(this);
            littleBabies.add(child);
        }
        this.children.addAll(littleBabies);
    }

    public List<Node<T>> getChildren() {
        if(this.children.size() == 0) {
            return null;
        }
        return this.children;
    }

    public Node<T> getChild(int idx){ 
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

    public void preOrder(int num){
        //String s = "";
        String extra = "";

        if(this.getParent() != null){
            extra+="__";
        }

        System.out.print(indent(num));
        System.out.println("");
        System.out.print(indent(num));
        System.out.println(extra+" "+this.getName());

        /*
        s+=indent(num);
        s+="\n";
        s+=indent(num);
        s+=extra+" "+ this.getName();

        System.out.println(s);
         */

        if(this.getChildren().size() > 0){
            num++;
        }

        for(Node<T> n: this.getChildren()){
            n.preOrder(num);
        }
        //return s;
    }

    public void displayChildren(int num) {
        String extra = "";
        extra+="__";

        num+=2;

        System.out.println("  "+this.getName());
        //System.out.println("");
        //System.out.print(indent(num));

        for(Node n: this.getChildren()){
            System.out.println("");
            System.out.print(indent(num));
            System.out.println(extra+" "+n.getName());
        }

    }

    public String toString(){
        String str = ""+ "NAME: " + this.name;
        str+= this.data.toString() + "\n";
        for(Node n: this.children){

            str+=n.toString() + "\n";
        }
        return str;
    }

    public static String indent(int num){
        String s = "";
        for(int i = 0; i < num; i++){
            s+="    |";
        }
        return s;
    }

    public static void main(String[] args){
        DataItem d0 = new DataItem("File", "Test Data Item Node", 1);
        DataItem d1 = new DataItem("File 1", "Second test Item (Child)", 1);
        DataItem d2 = new DataItem("File 2", "Third test Item (Child)", 1);
        DataItem d3 = new DataItem("File 2", "Third test Item (Child)", 1);
        DataItem d4 = new DataItem("File 3", "Fourth test Item (Child)", 1);
        DataItem d5 = new DataItem("File 4", "Fifth test Item (Child)", 1);
        DataItem d6 = new DataItem("File 5", "Sixth test Item (Child)", 1);
        DataItem d7 = new DataItem("File 6", "Seventh test Item (Child)", 1);
        DataItem d8 = new DataItem("File 7", "Eighth test Item (Child)", 1);
        DataItem d9 = new DataItem("File 8", "Nineth test Item (Child)", 1);

        //new tree node

        Node tree = new Node(d0, "Root Node DataItem 0");
        tree.addChild(d1, "Left Child From root Node with Data Item One");
        tree.addChild(d2, "Right Child from root node with dataItem two");
        tree.addChild(d5, "Third Child from root node with dataItem two");
        tree.getChild(2).addChild(d8, "third root child's child");
        tree.getChild(0).addChild(d3, "Right child of root LeftChild. Third layer");
        tree.getChild(0).addChild(d4, "Left child of root left child. Third layer");
        tree.getChild(0).addChild(d3, "Right child of root LeftChild. Third layer");
        tree.getChild(0).addChild(d4, "Left child of root left child. Third layer");
        tree.getChild(0).addChild(d3, "Right child of root LeftChild. Third layer");
        tree.getChild(0).addChild(d4, "Left child of root left child. Third layer");

        tree.getChild(0).getChild(1).addChild(d9, "This is so cool");
        tree.getChild(0).getChild(1).addChild(d9, "This is so cool aahhhhhhhhhhahahahaahhahahahaahh");
        tree.getChild(0).getChild(1).addChild(d9, "This is so cool l o l o l o l o");
        tree.getChild(0).addChild(d3, "Right child of root LeftChild. Third layer");
        tree.getChild(0).addChild(d4, "Left child of root left child. Third layer");
        tree.getChild(0).addChild(d3, "Right child of root LeftChild. Third layer");
        tree.getChild(0).addChild(d4, "Left child of root left child. Third layer");
        //int num = 0;
        //tree.preOrder(0);
        tree.displayChildren(0);
        //System.out.println(tree.preOrder(0));
        //preorder(tree, num);

    }
}