import java.util.*;

public class CMD {
    private List<String> CMDs;
    public CMD(){
        CMDs = new ArrayList<>();
    }
    
    
    public void clear(){
        System.out.print('\u000C');  
    }
    
    
    public void print(String str) {
        System.out.println(str);
    }
    
    
    public void space() throws InterruptedException{
        Thread.sleep(50);
        System.out.println(" ");
    }
    
    public void pause(int duration) throws InterruptedException{
        Thread.sleep(duration);
    }
    
    
    public void typeNewLine(String str, int speed) throws InterruptedException{
        System.out.println(" ");
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.substring(i, i+1));
            Thread.sleep(speed);
        }
        System.out.println(" ");
    }
    
    public void typeSameLine(String str, int speed) throws InterruptedException{
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.substring(i, i+1));
            Thread.sleep(speed);
        }
        System.out.print(" ");
    }
    
    
    public void formatPrint(String textToDisplay, int numberOfTimes, int delay) throws InterruptedException{
        for(int i = 0; i < numberOfTimes; i++){
            System.out.println("***  " + textToDisplay + "  ***");
            Thread.sleep(delay);
        }
    }
    
    public double CPE(String input, String possibleInput){
        String[] inputSplit = input.split(" ");
        int count = 0;
        int length = inputSplit.length;
        for(String s: inputSplit){
            if(possibleInput.indexOf(s) >=0){
                count+=1;
            }
        }
        double percentage = (count / length) * 100;
        return percentage;
    }
    
    //check for several inputs here
    public void checkSeveral(String input, Map<String, String> inputOutputPair, String question) throws InterruptedException{ 
        input = input.trim().toLowerCase();
        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        // making clone to use for checking input without caps
        Map clone = new HashMap<String, String>();
        for(String s: inputOutputPair.keySet()){
            clone.put(s.trim().toLowerCase(), inputOutputPair.get(s));
        }
        
        if(clone.containsKey(input)){
            String closestOutput = clone.get(input)+"";
            pass = true;
            typeNewLine(closestOutput, 50);
        }
        else {
            recurBasedOnPercent(input, clone, question);
        }
        
        
    }
    
    public void recurBasedOnPercent(String input, Map<String, String> map, String question) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        String query;
        double percent = 0.0;
        String posInp = "";
        String posOut = "";
        
        if(map.containsKey(input)){
            posOut = map.get(input)+"";
            typeNewLine(posOut, 50);
        }
        else {
            for(String s: map.keySet()){
                if(CPE(input, s) >= percent){
                    percent = CPE(input, s);
                    posInp = s;
                    posOut = map.get(s);
                }
            }
            pause(1000);
            typeNewLine("Did you mean " + "'"+ posInp + "'?", 50);
            pause(1000);
            query = sc.nextLine();
            pause(1000);
            if(query.trim().toLowerCase().equals("yes")){
                recurBasedOnPercent(posInp, map, question);
            }
            else if(query.trim().toLowerCase().equals("no")){
                pause(1000);
                typeNewLine("I'm sorry I cannot help you with your request.", 50);
                pause(500);
                typeNewLine(question, 50);
                pause(1000);
                query = sc.nextLine();
                pause(1000);
                recurBasedOnPercent(query, map, question);
            }
            else {
                pause(1000);
                typeNewLine("I couldn't understand your query.", 50);
                pause(500);
                typeNewLine(question, 50);
                pause(1000);
                query = sc.nextLine();
                recurBasedOnPercent(query, map, question);
            }
        }
        
    }
    
    
    public boolean checkPossibleInputs(String input, String desired1, String output1, String desired2, String output2, String question) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        boolean pass = false;
        input = input.trim().toLowerCase();
        desired1 = desired1.trim().toLowerCase();
        desired2 = desired2.trim().toLowerCase();
        if(input.equals(desired1)){
            pause(1000);
            typeNewLine(output1, 50);
            pass = true;
            return pass;
        }
        else if(input.equals(desired2)){
            pause(1000);
            typeNewLine(output2, 50);
            pass = true;
            return pass;
        }
        else if(desired1.indexOf(input) >= 0 || input.indexOf(desired1) >= 0 || CPE(input, desired1) >= 50.0){
            pause(1000);
            typeNewLine("Did you mean " + "'"+ desired1 + "'?", 50);
            String nextQuery = sc.nextLine();
            if(nextQuery.trim().toLowerCase().equals("yes")){
                pass = checkPossibleInputs(desired1, desired1, output1, desired2, output2, question);
            }
            else{
                typeNewLine("I couldn't understand your previous query. Try another input; preferably, the correct input.", 50);
                pause(500);
                typeNewLine(question, 50);
                nextQuery = sc.nextLine();
                pass = checkPossibleInputs(nextQuery, desired1, output1, desired2, output2, question);
            }
            return pass;
        }
        else if(desired2.indexOf(input) >= 0 || input.indexOf(desired2) >= 0 || CPE(input, desired2) >= 50.0){
            pause(1000);
            typeNewLine("Did you mean " + "'"+ desired2 + "'?", 50);
            String nextQuery = sc.nextLine();
            if(nextQuery.trim().toLowerCase().equals("yes")){
                pass = checkPossibleInputs(desired2, desired1, output1, desired2, output2, question);
            }
            else{
                typeNewLine("I couldn't understand your previous query. Try another input; preferably, the correct input.", 50);
                pause(500);
                typeNewLine(question, 50);
                nextQuery = sc.nextLine();
                pass = checkPossibleInputs(nextQuery, desired1, output1, desired2, output2, question);
            }
            return pass;
        }
        else {
            pause(500);
            typeNewLine("I cannot understand that query. Try the correct input.", 50);
            pause(1000);
            typeNewLine(question, 50);
            String nextQuery = sc.nextLine();
            pass = checkPossibleInputs(nextQuery, desired1, output1, desired2, output2, question);
            return pass;
        }
    }
    
    public boolean checkAndSpit(String input, String desired, String output) throws InterruptedException{
        boolean pass = false;
        if(input.trim().toLowerCase().equals(desired.toLowerCase())){
            pause(1000);
            typeNewLine(output, 50);
            pass = true;
            return pass;
        }
        else if(desired.indexOf(input.trim().toLowerCase()) >= 0){
            pause(1000);
            typeNewLine("Did you mean " + "'"+ desired + "'?", 50);
            return pass;
        }
        else {
            pause(500);
            typeNewLine("I cannot understand that query. Try the correct input.", 50);
            return pass;
        }
    }
    
}