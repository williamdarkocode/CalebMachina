import java.util.*;

public class Blackbox {
    private Options ops;
    private CMD cmd;
    private Map queryAnswerPair;
    public Blackbox(){
        ops = new Options();
        ops.addOption("My options");
        cmd = new CMD();
        queryAnswerPair = new HashMap<String, String>();
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
        cmd.pause(500);
        cmd.space();
        cmd.pause(500);
        cmd.typeNewLine("Loading", 50);
        cmd.typeNewLine("*******************************************************************************************************************************************************", 10);
        cmd.space();
        cmd.pause(500);
        Thread.sleep(forepause);
        cmd.typeSameLine("Hello Caleb.", 50);
        cmd.pause(500);
        cmd.typeSameLine("My name Ava;", 50);
        cmd.pause(500);
        cmd.typeSameLine("the system control AI", 50);
        cmd.space();
        cmd.typeNewLine("I was receiving a ping from you. ", 50);
        cmd.pause(500);
        cmd.typeNewLine("Were you requesting to boot?", 50);
    }
    
    public void checkAndSpit(String input, String) {
    }
    
    public void generateResponce(){
        
        queryAnswerPair.put("hi ava", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("hello ava", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("hi ava", "Yes Caleb, How can I help you?");
        
    }
    
}