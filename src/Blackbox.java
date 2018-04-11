import java.util.*;

public class Blackbox {
    private Options ops;
    private CMD cmd;

    public Blackbox(){
        ops = new Options();
        ops.addOption("My options");
        cmd = new CMD();

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
                
                         
        cmd.typeNewLine("Caleb");
    }

    public void generateResponce(String input){
        Map queryAnswerPair = new HashMap<String, String>();
        queryAnswerPair.put("hi ava", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("hello ava", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("hi", "Yes Caleb, How can I help you?");
        queryAnswerPair.put("ava", "Yes Caleb, How can I help you?");

    }

}