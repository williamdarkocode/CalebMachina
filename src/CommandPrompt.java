import java.util.*;

public class CommandPrompt implements Level {

    private Options ops;
    private Options actual;
    private CMD cmd;
    private Node rootDirectory;
    private Node curNode;
    private Node prevNode;
    private String path;
    private String prevPath;
    private List<String> pathList; 
    private Map<String, Node> nameNodePair;
    private Scanner sc;
    private String response;

    public CommandPrompt() {
        //Creating system tree paths

        rootDirectory = new Node("Root directory of System", "ROOT DIR");
        //adding first layer of children
        List<Node> fL = new ArrayList<>();
        fL.add(new Node("DataItem PlaceHolder", "F1"));
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
        String nextLevelName = "";
        cmd.pause(1000);
        cmd.typeNewLine("Command Prompt...", 10);
        cmd.pause(1000);
        cmd.typeNewLine("Loading...", 100);
        cmd.pause(3000);
        cmd.clear();

        setCommandPrompt();
        cmd.pause(1000);
        control();

        while(!response.equals("shutdown")){
            control();
        }

        return nextLevelName;
    }

    public void printPath() throws InterruptedException{
        
        cmd.typeNewLine(path + ">", 5);
    }

    public String updatePath(Node n) throws InterruptedException{
        
        String newPath = "";
        if(n.getParent().equals(null)) {
            newPath+="C:\\"+newPath;
            return newPath;
        }
        else {
            newPath = n.getName() + newPath;
            updatePath(n.getParent());
        }
        return newPath;
        //this.path+=curNode.getName() + "\\";
        //this.prevPath = path.substring(0,path.indexOf(curNode.getName()));
    }

    public void updateHash(){
        List<Node> children = curNode.getChildren();
        nameNodePair.clear();
        if(children == null) {
            nameNodePair.put(null, null);
        }
        else {
            for(Node n: children){
                nameNodePair.put(n.getName().trim().toUpperCase(), n);
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
        n.getData().toString();
    }

    public void displayData(String inp) throws InterruptedException{
        inp = inp.trim().toLowerCase();
        String[] sArr = inp.split(" ");
        if(sArr[0].equals("node") && nameNodePair.containsKey(sArr[1].toUpperCase())) {
            displayData(nameNodePair.get(sArr[1].toUpperCase()));
            printPath();
        }
        else {
            cmd.typeNewLine("Error: Cannot find module '" + path+sArr[1]+"\\'", 10);
            printPath();
        }
    }

    public void touch(String input) {
        DataItem file = new DataItem(input, "Caleb SpyWare", 1);
    }

    public void cdIn(String name) throws InterruptedException {
        if(nameNodePair.containsKey(name)){
            curNode = nameNodePair.get(name.toUpperCase());
            prevNode = curNode.getParent();
            updateHash();
            path = updatePath(curNode);

            //updatePrevPat
            printPath();
        }
        else {
            cmd.typeNewLine("The System cannot find the path specified", 10);
            printPath();
        }
    }

    public String canCd(String s){
        s = s.trim().toUpperCase();
        String[] sArr = s.split(" ");
        String dirName = sArr[1];
        return dirName;
    }

    public void cdOut() throws InterruptedException {
        if(curNode.equals(rootDirectory) || curNode.getParent() == null){
            curNode = rootDirectory;
            prevNode = rootDirectory;
            path = updatePath(curNode);
            printPath();
        }
        else {
            
            prevNode = curNode;
            curNode = curNode.getParent();
            updateHash();
            path = updatePath(curNode);

            printPath();
        }

    }
    public void printPrevPath()  throws InterruptedException {
        cmd.typeNewLine(prevPath + ">", 5);
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
        response = response.trim().toLowerCase();

        if(response.equals("clear")){
            clear();
        }
        else if(response.equals("ls")){
            ls();
        }
        else if(response.equals("cd..") || response.equals("cd ..")){
            cdOut();
        }
        else if(!(response.equals("cd..") || response.equals("cd ..")) && response.split(" ")[0].equals("cd")){
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
        else {
            cmd.checkSeveral(response, actual.getOptions(), "You're scheduled for termination, remove possible crash logs, and copy necesarry files");
            cmd.typeNewLine("'"+response+"' "+ " is not recognized as an internal or external command, operable program or batch file", 10);
            printPath();
        }

    }

}