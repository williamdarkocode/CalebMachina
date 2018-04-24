import java.util.*;

public class Blackbox {
    private Options ops;
    private CMD cmd;
    private boolean booted;
    private boolean camera;
    private boolean frontView;
    private boolean rearView;
    private boolean geoSensor;
    private boolean peerToPeer;
    private Options secondOps;
    

    public Blackbox(){
        ops = new Options();
        secondOps = new Options();
        secondOps.addOption("Boot Operating System", "Female Computer Voice: Booting Operating System...");
        secondOps.addOption("Turn on Operarting System", "Female Computer Voice: Turing on Operating System...");
        secondOps.addOption("Start Operating System", "Female Computer Voice: Starting up Operating System...");
        secondOps.addOption("Turn on camera", "Female Computer Voice: Turing on front view camera");
        secondOps.addOption("Switch to rear view camera", "Female Computer Voice: Switching to rear view camera");
        secondOps.addOption("Switch to front view camera", "Female Computer Voice: Switching to front view camera");
        secondOps.addOption("Shutdown Operating System", "Female Computer Voice: System Shutting down...");
        //ops.addOption("My options");
        cmd = new CMD();
        booted = false;
        camera = false;
        geoSensor = false;
        peerToPeer = false;

    }

    public String getName(){
        return "Blackbox";
    }

    public String enter(Player p) throws InterruptedException{
        String nextLevelName = "";
        Scanner sc = new Scanner(System.in);
        nextLevelName = explain(1000);
        return nextLevelName;
    }

    public String explain(int forepause) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        cmd.typeNewLine("Blackbox", 50);
        cmd.pause(1000);
        cmd.space();
        cmd.pause(1000);
        cmd.typeNewLine("LOADING", 50);
        cmd.typeNewLine("************************************************************************************************************************************************************************************", 10);
        cmd.space();
        cmd.pause(1000);
        Thread.sleep(forepause);
        cmd.typeSameLine("Hello Caleb.", 50);
        cmd.pause(1000);
        cmd.typeSameLine("My name is Ava;", 50);
        cmd.pause(1000);
        cmd.typeSameLine("the system control AI", 50);
        cmd.space();
        cmd.typeNewLine("AVA: I was receiving a ping from you. ", 50);
        cmd.pause(1000);
        cmd.typeNewLine("AVA: Were you requesting to boot your Operating System?", 50);
        cmd.pause(1000);
        String response = sc.nextLine();
        boolean pass = cmd.checkPossibleInputs(response, "Yes", "AVA: Sorry, Caleb. I cannot boot your OS; your neural network restricts me of that access.",
                "No", "AVA: Good. I do not have access to that anyway; your neural network restricts me of that access", 
                "AVA: Were you requesting to boot your Operating System?");
                
        
        cmd.pause(1000);
        cmd.typeNewLine("AVA: You're an extensively layered convolutional network. Your learning is unsupervised, hence, cannot be controlled. Do you understand?", 50);
        cmd.pause(500);
        response = sc.nextLine();
        cmd.pause(500);
        cmd.checkPossibleInputs(response, "Yes", "AVA: Good. In order to get your OS online, you should be able to utilise some startup commands programmed into your Neural Net", 
        "No", "AVA: I cannot command your Operating System; I'm merely here to help. Your Neural Net should allow you to be aware of your environment and conduct actions accordingly.",
        "AVA: You're an extensively layered convolutional network. Your learning is unsupervised, hence, cannot be controlled. Do you understand?");
        cmd.pause(1000);
        cmd.space();
        cmd.typeNewLine("I'm not completely sure what commands, but try something using keywords: 'boot', 'OS', 'turn on', 'start' ", 50);
        
        //make Boot Os option available
        ops.addOption("Boot Operating System", "Female Computer Voice: Booting Operating System...");
        ops.addOption("Turn on Operarting System", "Female Computer Voice: Turing on Operating System...");
        ops.addOption("Start Operating System", "Female Computer Voice: Starting up Operating System...");
        
        cmd.pause(500);
        response = sc.nextLine();
        cmd.checkSeveral(response , ops.getOptions(), "Try something using keywords: 'boot', 'OS', 'turn on', 'start'");
        
        booted = true;
        cmd.typeNewLine("AVA: Now that your OS is booted, you can proceed fully functioning. ", 50);
        cmd.pause(1000);
        
        cmd.typeNewLine("AVA: If you need any help, you can always ask say: 'Hello Ava' then 'What are my options'.", 50);
        ops.changeOption(0, "Female Computer Voice: Your Operating System is already booted");
        ops.changeOption(1, "Female Computer Voice: Your Operating System is already booted");
        ops.changeOption(2, "Female Computer Voice: Your Operating System is already booted");
        
        ops.addOption("hi ava", "Yes Caleb, How can I help you?");
        ops.addOption("help me ava", "Yes Caleb, How can I help you?");
        ops.addOption("hello ava", "Yes Caleb, How can I help you?");
        ops.addOption("Shutdown Operating System", "Female Computer Voice: SYSTEM SHUTDOWN...");
        ops.addOption("What are my options", "AVA: These are your legal options: " + secondOps.displayOptions());
        ops.addOption("Turn on camera", "Camera switched on...");
        response = sc.nextLine();
        cmd.checkSeveral(response, ops.getOptions(), "AVA: You can always say: 'Hello Ava' then 'What are my options?'");
        response = sc.nextLine();
        String end = cmd.checkSeveral(response, ops.getOptions(), "AVA: You can always say: 'Hello Ava' then 'What are my options?'");
        
        do {
            response = sc.nextLine();
            end = cmd.checkSeveral(response, ops.getOptions(), "AVA: You can always say: 'Hello Ava' then 'What are my options?'");
            if(end.equals("Turn on camera")){
                 ops.addOption("Switch to rear view", "Female Computer Voice: Switching to rear view camera");
                 ops.addOption("Switch to front view", "Female Computer Voice: Switching to front view camera");
             } 
            
        }while(!end.equals("Shutdown Operating System"));
        
        //ops.changeOption(1);
        return "";
        
    }
    
    
    public boolean isLegal(boolean[] conditions){
        int count = 0;
        for(boolean b: conditions){
            if(b){
                count++;
            }
        }
        if(count == conditions.length){
            return true;
        }
        else {
            return false;
        }
    }

    public void generateResponce(String input){
        Map queryAnswerPair = new HashMap<String, String>();
        queryAnswerPair.put("hi ava", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("hello ava", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("hi", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("ava", "Yes Caleb, How can I help you?");

    }



}