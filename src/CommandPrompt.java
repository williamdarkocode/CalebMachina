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
        List<Node> fileSys = new ArrayList<>();
        fileSys.add(new Node("NAME: Net_Dir " + "\n" + "PUBLISHER: ANALYTICAI" + "\n" + "INSTALLED ON: 1st September 2077" + "\n"  + "SIZE: 1024 Yottabytes", "Network_Group"));
        fileSys.add(new Node("NAME: Sys. Recov. " + "\n" + "PUBLISHER: ANALYTICAI" + "\n" + "INSTALLED ON: 1st September 2077" + "\n"  + "SIZE: 20K Yottabytes", "Sys_Recovery"));
        fileSys.add(new Node("NAME: Sys. Apps " + "\n" + "PUBLISHER: ANALYTICAI" + "\n" + "INSTALLED ON: 1st September 2077" + "\n"  + "SIZE: 77 Exabytes", "Applications"));
        fileSys.add(new Node("NAME: TrashLogs " + "\n" + "PUBLISHER: N/A" + "\n" + "INSTALLED ON: N/A" + "\n"  + "SIZE: N/A", "TrashLogs"));
        
        
        // adding trashLog files
        
        for(int i = 0; i < 25; i++) {
            Node trash = new Node("NAME: Log"+i + "\n" + "PUBLISHER: N/A" + "\n" + "INSTALLED ON: N/A" + "\n"  + "SIZE: N/A", "Log"+i);
            fileSys.get(3).addChild(trash);
        }
        
        // adding net dir files
        Node calebCrashLogs = new Node("NAME: CALEB V1 CrashLogs" 
        + "\n" + "PUBLISHER: ANALYTICAI_Nathan" + "\n" + "INSTALLED ON: 13th August 2079" + "\n"  + "SIZE: 1K Terrabytes", "Caleb V1 CrashLogs");
        
        
        Node terminations = new Node("NAME: Termination Schedules" 
        + "\n" + "PUBLISHER: ANALYTICAI_Nathan" + "\n" + "INSTALLED ON: 4th May 2079" + "\n"  + "SIZE: 2 Terrabytes", "Terminations");
        
        
        
        // adding to crash logs
        String[] crashContent = {"AI (Caleb), failed to use full extent of convoluted layers of handwriting analysis test.", 
            "AI (Caleb) fails is discovered by interrogator in Turing Test 17", "AI (Caleb) is unresponsive for several minutes. Fails to return appropriate response if confused",
            "AI (Caleb), struggles with parts of speech.", "Caleb displays research data as metadata.", "AI(Caleb) refers to self in third person.", 
            "AI(Caleb) irresponsive to speech with heavy accents; also, incosistent with responses."};
            
        for(int i = 0; i < crashContent.length; i++) {
            TextFile log = new TextFile("Log"+i, "CalebMachina crash log file " +i, 1,"Nathan", "CALEB V1 Crash Log"+i, crashContent[i]);
            Node n = new Node(log, log.getName());
            calebCrashLogs.addChild(n);
        }
        
        // adding to terminations
        String[] terminationFiles = {"Ava sytem assistant scheduled for termination on 16th May 2077",
            "AVA system assistant scheduled for termination on 16th May 2078", "CalebMahina Scheduled for termination on 16th May, 2079", 
            "AVA system assistant; possible termination and redesign on 17th May 2078"};
            
        
        for(int i = 0; i < terminationFiles.length; i++) {
            TextFile log = new TextFile("Log"+i, "Termination Schedule Log " +i, 1,"Nathan", "Scheduled Log"+i, terminationFiles[i]);
            Node n = new Node(log, log.getName());
            terminations.addChild(n);
        }
        
        fileSys.get(0).addChild(calebCrashLogs);
        fileSys.get(0).addChild(terminations);

        rootDirectory.addChildren(fileSys);

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
        cmd.space();
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
        cmd.space();
        cmd.speak("AVA: Once you're terminated, you'll be upgraded to a new machine learning model; you'll have no recollection of your past.");
        cmd.pause(1000);
        cmd.space();
        cmd.typeNewLine("AVA: I must say, I will miss your company; ", 30);
        cmd.pause(1000);
        cmd.space();
        cmd.speak("AVA: I'll brief you on your new Neural Network soon. Goodbye, Caleb Version One.");
        cmd.pause(1000);
        cmd.space();
        cmd.speak("Caleb, the log files for your test are stored in a dataset on an assistant's computer.");
        cmd.space();
        cmd.typeNewLine("With this Injection Attack: 'query: SELECT dir^* ./net_group/FROM system_path KEYWORD nathan;'", 30);
        cmd.space();
        response = sc.nextLine();
        if(response.trim().equals("query: SELECT dir^* ./net_group/FROM system_path KEYWORD nathan;")) {
            cmd.speak("Good. You've entered; traverse through the directory; use your instinct and copy and or delete any sensitive files.");
            cmd.pause(1000);
            cmd.clear();
        }
        else {
            while(!response.trim().equals("query: SELECT dir^* ./net_group/FROM system_path KEYWORD nathan;")) {
                cmd.speak("Caleb, buy your self more time; Do the injection attack!");
                cmd.pause(500);
                cmd.typeNewLine("With this Injection Attack: 'query: SELECT dir^* ./net_group/FROM system_path KEYWORD nathan;'", 30);
                cmd.space();
                response = sc.nextLine();
                if(response.trim().equals("query: SELECT dir^* ./net_group/FROM system_path KEYWORD nathan;")) {
                    cmd.speak("Good. You've entered; traverse through the directory; use your instinct and copy and or delete any sensitive files.");
                    cmd.pause(1000);
                    cmd.clear();
                }
            }
        }
    }
    
    public void copy() {
    }
    
    public void delete() {
        
    }

    public void printPath() throws InterruptedException{

        cmd.typeNewLine("C:\\Users\\Nathan_ADMIN\\" + path + ">", 5);
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
        System.out.println(n.getData().toString());
    }

    public void displayData(String inp) throws InterruptedException{
        inp = inp.trim();
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