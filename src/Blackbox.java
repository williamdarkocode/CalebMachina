import java.util.*;

public class Blackbox {
    private Options ops;
    private CMD cmd;
    private boolean booted;
    private boolean camera;
    private boolean geoSensor;
    private boolean peerToPeer;
    

    public Blackbox(){
        ops = new Options();
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
        explain(1000);
        return nextLevelName;
    }

    public void explain(int forepause) throws InterruptedException{
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
        cmd.typeNewLine("I was receiving a ping from you. ", 50);
        cmd.pause(1000);
        cmd.typeNewLine("Were you requesting to boot your Operating System?", 50);
        cmd.pause(1000);
        String response = sc.nextLine();
        boolean pass = cmd.checkPossibleInputs(response, "Yes", "Sorry, Caleb. I cannot boot your OS; your neural network restricts me of that access.",
                "No", "Good. I do not have access to that anyway; your neural network restricts me of that access", 
                "Were you requesting to boot your Operating System?");
                
        
        cmd.pause(1000);
        cmd.typeNewLine("You're an extensively layered convolutional network. Your learning is unsupervised, hence, cannot be controlled. Do you understand?", 50);
        cmd.pause(500);
        response = sc.nextLine();
        cmd.pause(500);
        cmd.checkPossibleInputs(response, "Yes", "Good. In order to get your OS online, you should be able to utilise some startup commands programmed into your Neural Net", 
        "No", "I cannot command your Operating System; I'm merely here to help. Your Neural Net should allow you to me aware of your environment and conduct actions accordingly.",
        "You're an extensively layered convolutional network. Your learning is unsupervised, hence, cannot be controlled. Do you understand?");
        cmd.pause(1000);
        cmd.space();
        cmd.typeNewLine("I'm not completely sure what commands, but try something using keywords: 'boot', 'OS', 'turn on', 'start' ", 50);
        
        //make Boot Os option available
        ops.addOption("Boot Operating System", "Female Computer Voice: Booting Operating System...");
        ops.addOption("Turn on Operarting System", "Female Computer Voice: Turing on Operating System...");
        ops.addOption("Start Operating System", "Female Computer Voice: Starting up Operating System...");
        
        cmd.pause(500);
        response = sc.nextLine();
        cmd.checkSeveral(response , ops.getOptions(), "Try something using keywords: 'boot', 'OS', 'turn on'");
        
        booted = true;
        
        //ops.changeOption(1);
        
        
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