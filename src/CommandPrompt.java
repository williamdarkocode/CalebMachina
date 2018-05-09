import java.util.*;

public class CommandPrompt implements Level {

    private Options ops;
    private Options actual;
    private CMD cmd;
    private Node rootDirectory;
    private Node curNode;
    private Node prevNode;
    private String path;
    private String pathTracker;
    private List<String> pathList; 
    private Map<String, Node> nameNodePair;
    private Scanner sc;
    private String response;

    public CommandPrompt() {
        //Creating system tree paths

        rootDirectory = new Node("Root directory of System", "ROOT DIR");
        //adding first layer of children
        List<Node> fL = new ArrayList<>();
        fL.add(new Node("DataItem PlaceHolder", "f1"));
        fL.add(new Node("DataItem PlaceHolder", "F2"));
        fL.add(new Node("DataItem PlaceHolder", "F3"));
        fL.add(new Node("DataItem PlaceHolder", "F4"));
        fL.add(new Node("DataItem PlaceHolder", "F5"));
        fL.add(new Node("DataItem PlaceHolder", "F6"));
        fL.add(new Node("DataItem PlaceHolder", "F7"));
        fL.add(new Node("DataItem PlaceHolder", "F8"));

        rootDirectory.addChildren(fL);

        path = rootDirectory.getName() + ":\\" ;
        curNode = rootDirectory;
        prevNode = curNode.getParent();

        nameNodePair = new HashMap<String, Node>();

        actual = new Options();
        actual.addOption("ls", "");
        actual.addOption("mkdir", "");
        actual.addOption("touch", "");
        actual.addOption("cd ..", "");
        actual.addOption("cd", "");
        actual.addOption("clear", "");
        actual.addOption("node", "");
        actual.addOption("path-config", "");
        actual.addOption("shutdown", "");

        ops = new Options();
        ops.addOption("Hello Ava", "AVA: Yes, Caleb. How may I help you?");
        ops.addOption("What are my options", actual.displayOptions());

        sc = new Scanner(System.in);
        cmd = new CMD();
        //response = sc.nextLine();

        updateHash();
    }

    @Override
    public String getName(){
        return "CommandPrompt"; 
    }

    @Override
    public String enter(Player p) throws InterruptedException{
        cmd.clear();
        String nextLevelName = "";
        cmd.pause(1000);
        cmd.typeNewLine("C  O   M   M   A   N   D       P   R   O   M   P   T", 10);
        cmd.pause(1000);
        cmd.typeNewLine("L  O   A   D   I   N   G   .   .   .   ", 100);
        cmd.pause(3000);
        cmd.clear();
        
        
        tellStory();
        
        cmd.pause(2000);

        setCommandPrompt();
        cmd.pause(1000);
        control();

        while(!response.equals("shutdown")){
            control();
        }

        return nextLevelName;
    }

    public void tellStory() throws InterruptedException{
        cmd.typeNewLine("AVA: Hello Caleb, I regret to inform that your termination has been scheduled for earlier today.", 30);
        cmd.pause(1000);
        cmd.typeNewLine("AVA: Once you're terminated, you'll be upgraded to a new machine learning model; ", 30);
        cmd.pause(1000);
        cmd.typeSameLine("you'll have no recollection of your past.",30);
        cmd.pause(1000);
        cmd.typeNewLine("AVA: I must say, I will miss your company; ", 30);
        cmd.pause(1000);
        cmd.typeSameLine("AVA: I'll brief you on your new Neural Network soon. Goodbye, Caleb Version One.", 30);
        
        
    }

    public void printPath() throws InterruptedException{

        cmd.typeNewLine("C:\\" + path + ">", 5);
    }

    public String updatePath(Node n) throws InterruptedException{
        String newPath = "";
        if(n.equals(rootDirectory)) {
            path = n.getName()+ "\\" + path;
            return path;
        }
        else {
            path = n.getName() + "\\" + path;
            updatePath(n.getParent());
        }

        return path;
        //this.path+=curNode.getName() + "\\";
        //this.prevPath = path.substring(0,path.indexOf(curNode.getName()));
    }

    public void updateHash(){
        List<Node> children = curNode.getChildren();
        nameNodePair.clear();
        if(children.equals(null)) {
            nameNodePair = new HashMap<String, Node>();
        }
        else {
            for(Node n: children){
                nameNodePair.put(n.getName().trim(), n);
            }
        }
    }


    public void ls() throws InterruptedException{
        curNode.displayChildren(0);
        printPath();
    }

    public void nodeConfig() throws InterruptedException{
        curNode.preOrder(0);
        printPath();
    }

    public void displayData(Node n){
        System.out.println(n.getData());
    }

    public void displayData(String inp) throws InterruptedException{
        inp = inp.trim().toLowerCase();
        String[] sArr = inp.split(" ");
        if(sArr[0].equals("node") && nameNodePair.containsKey(inp.substring(4).trim())) {
            displayData(nameNodePair.get(inp.substring(4).trim()));
            printPath();
        }
        else {
            cmd.typeNewLine("Error: Cannot find module '" + path+sArr[1]+"\\'", 10);
            printPath();
        }
    }

    public void touch(String input) throws InterruptedException{
        DataItem file = new DataItem(input, "Caleb SpyWare", 1);
        Node newNode = new Node(file, input);
        //List<Node> deadKiddies = null;
        //newNode.setChildren(deadKiddies);

        if (nameNodePair.containsKey(input) /*|| nameNodePair.containsKey(input.toUpperCase()) || nameNodePair.containsKey(input.toLowerCase())*/) {
            cmd.typeNewLine("File name already taken in directory!", 10);
            printPath();
        }
        else {
            curNode.addChild(newNode, input);
            printPath();
            updateHash();
        }
    }

    public void cdIn(String name) throws InterruptedException {
        name = name.trim();
        if(nameNodePair.containsKey(name) /*&& nameNodePair.get(name).getChildren() != null*/ && nameNodePair.get(name).getData().getClass().getName().indexOf("DataItem") < 0){
            curNode = nameNodePair.get(name);
            prevNode = curNode.getParent();
            updateHash();
            pathTracker = "";
            path = "";
            path = updatePath(curNode);

            //updatePrevPat
            printPath();
        }
        /*
        else if((nameNodePair.containsKey(name.toUpperCase()) /*&& nameNodePair.get(name.toUpperCase()).getChildren() != null) 
        && nameNodePair.get(name.toUpperCase()).getData().getClass().getName().indexOf("DataItem") < 0){
        curNode = nameNodePair.get(name.toUpperCase());
        prevNode = curNode.getParent();
        updateHash();
        path = updatePath(curNode);

        //updatePrevPat
        printPath();
        }
         */
        else if(nameNodePair.containsKey(name) /*&& nameNodePair.get(name).getChildren() == null */&& nameNodePair.get(name).getData().getClass().getName().indexOf("DataItem") >= 0) {
            cmd.typeNewLine("The directory name is invalid", 10);
            printPath();
        }
        /*
        else if(nameNodePair.containsKey(name.toUpperCase()) /*&& nameNodePair.get(name.toUpperCase()).getChildren() == null 
        && nameNodePair.get(name.toUpperCase()).getData().getClass().getName().indexOf("DataItem") >= 0) {
        cmd.typeNewLine("The directory name is invalid", 10);
        printPath();
        }
         */
        else {
            cmd.typeNewLine("The System cannot find the path specified", 10);
            printPath();
        }
    }

    public String canCd(String s){
        s = s.trim();
        String dirName = s.substring(2).trim();
        return dirName;
    }

    public String canMkdir(String s) {
        s = s.trim();
        String dirName = s.substring(5).trim();
        return dirName;
    }

    public void mkdir(String name) throws InterruptedException{
        Node newDir = new Node("Sub-Directory "+  name, name);
        if (nameNodePair.containsKey(name) && nameNodePair.get(name).getData().getClass().getName().indexOf("DataItem") < 0 /*|| nameNodePair.containsKey(input.toUpperCase()) || nameNodePair.containsKey(input.toLowerCase())*/) {
            cmd.typeNewLine("A subdirectory or file '" + name + "' already exists.", 10);
            printPath();
        }
        else {
            curNode.addChild(newDir, name);
            updateHash();
            pathTracker = "";
            path = "";
            path = updatePath(curNode);
            printPath();

        }
    }

    public void cdOut() throws InterruptedException {
        if(curNode.equals(rootDirectory) || curNode.getParent() == null){
            curNode = rootDirectory;
            prevNode = rootDirectory;
            pathTracker = "";
            path = "";
            path = updatePath(curNode);
            printPath();
        }
        else {

            prevNode = curNode;
            curNode = curNode.getParent();
            updateHash();
            pathTracker = "";
            path = "";
            path = updatePath(curNode);

            printPath();
        }

    }

    public void setCommandPrompt() throws InterruptedException{
        cmd.typeNewLine("Macrohard Doors [Version 10.0.16299.371]", 5);
        cmd.typeNewLine("(c) 2071 Macrohard Doors. All rights not reserved.",5);
        cmd.pause(5);

        printPath();
    }

    public void clear() throws InterruptedException {
        cmd.clear();
        setCommandPrompt();
    }

    public void control() throws InterruptedException{
        this.response = sc.nextLine();
        response = response.trim();

        if(response.equals("clear")){
            clear();
        }
        else if(response.equals("ls")){
            ls();
        }
        else if(response.equals("cd") || response.equals("CD")) {
            printPath();
        }
        else if(response.equals("cd..") || response.equals("cd ..") || response.equals("CD..") || response.equals("CD ..")){
            cdOut();
        }
        else if(!(response.equals("cd..") || response.equals("cd ..") || response.equals("CD..") || response.equals("CD ..")) && (response.split(" ")[0].equals("cd") 
            || response.split(" ")[0].equals("CD") )){
            cdIn(canCd(response));
        }
        else if(response.equals("path-config")){
            nodeConfig();
        }
        else if(response.equals("node")){
            displayData(curNode);
        }
        else if(!response.equals("node") && response.split(" ")[0].equals("node")){
            displayData(response);
        }
        else if(response.equals("touch") || response.equals("TOUCH")) {
            cmd.typeNewLine(response + ": Missing file operand", 10);
        }
        else if(response.indexOf("touch") == 0 && !response.equals("touch")) {
            String fileName = response.substring(5).trim();
            touch(fileName);
        }
        else if(response.equals("mkdir") || response.equals("MKDIR")) {
            cmd.typeNewLine("The syntax of the command is incorrect", 10);
            cmd.typeNewLine("Syntax: mkdir 'sub-directory name'.", 10);
        }
        else if (!(response.equals("mkdir") || response.equals("MKDIR")) && response.split(" ")[0].trim().toLowerCase().equals("mkdir")) {
            mkdir(canMkdir(response));
        }

        else {
            //cmd.checkSeveral(response, actual.getOptions(), "You're scheduled for termination, remove possible crash logs, and copy necesarry files");
            if(!response.equals("")) {
                cmd.typeNewLine("'"+response+"' "+ " is not recognized as an internal or external command, operable program or batch file", 10);
                printPath();
            }
            else {
                printPath();
            }
        }

    }

}