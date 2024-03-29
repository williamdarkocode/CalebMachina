import java.util.*;

public class CMD {
    private List<String> CMDs;

    public static void clear(){
        System.out.print('\u000C');  
    }

    public static String indent(int numTimes){
        String s = "";
        for(int i = 0; i < numTimes; i++){
            s+="    ";
        }
        return s;
    }

    public static String getObjectType(Object obj){
        String type = obj.getClass()+"";
        return type.trim().substring(type.indexOf(" ")+1);
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void space() throws InterruptedException{
        System.out.println("    ");
    }

    public static void pause(int duration) throws InterruptedException{
        Thread.sleep(duration);
    }

    public static void typeNewLine(String str, int speed) throws InterruptedException{
        space();
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.substring(i, i+1));
            Thread.sleep(speed);
        }
        space();
    }

    public static void typeSameLine(String str, int speed) throws InterruptedException{
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.substring(i, i+1));
            Thread.sleep(speed);
        }
    }

    public static void formatPrint(String textToDisplay, int numberOfTimes, int delay) throws InterruptedException{
        for(int i = 0; i < numberOfTimes; i++){
            System.out.println("***  " + textToDisplay + "  ***");
            Thread.sleep(delay);
        }
    }

    public static void speak(String s) throws InterruptedException {
        space();
        int defaultPause = 30;
        for(int i = 0; i < s.length(); i++) {
            boolean comma = s.substring(i, i+1).equals(",");
            boolean fullStop = s.substring(i, i+1).equals(".");
            boolean semiColon = s.substring(i, i+1).equals(";");
            System.out.print(s.substring(i,i+1));
            if(comma) {
                Thread.sleep(defaultPause+470);
            }
            else if(semiColon) {
                Thread.sleep(defaultPause+770);
            }
            else if(fullStop) {
                Thread.sleep(defaultPause+970);
            }
            else {
                Thread.sleep(defaultPause);
            }
        }
        space();
    }

    public static double CPE(String input, String possibleInput){
        String[] inputSplit = input.split(" ");
        double count = 0.0;
        int length = inputSplit.length;
        for(String s: inputSplit){
            if(possibleInput.indexOf(s) >=0){
                count+=1.0;
            }
        }
        double percentage = (count / possibleInput.length())* 100;
        return percentage;
    }

    //check for several inputs here
    public static String checkSeveral(String input, Map<String, String> inputOutputPair, String question) throws InterruptedException{ 
        input = input.trim().toLowerCase();
        //Scanner sc = new Scanner(System.in);
        boolean pass = false;
        String str = "";
        // making clone to use for checking input without caps
        Map clone = new HashMap<String, String>();
        for(String s: inputOutputPair.keySet()){
            clone.put(s.trim().toLowerCase(), inputOutputPair.get(s));
        }

        if(clone.containsKey(input.trim()) || clone.containsKey(input.trim().toLowerCase()) || clone.containsKey(input.trim().toUpperCase())) {
            if(clone.containsKey(input.trim())) {
                String closestOutput = clone.get(input.trim())+"";
                pass = true;
                typeNewLine(closestOutput, 50);
                return input.trim().toLowerCase();
            }
            else if(clone.containsKey(input.trim().toLowerCase())) {
                String closestOutput = clone.get(input.trim().toLowerCase())+"";
                pass = true;
                typeNewLine(closestOutput, 50);
                return input.trim().toLowerCase();
            }
            else {
                String closestOutput = clone.get(input.trim().toUpperCase())+"";
                pass = true;
                typeNewLine(closestOutput, 50);
                return input.trim().toLowerCase();
            }
        }
        else {
            str = recurBasedOnPercent(input, clone, question);
            return str.trim().toLowerCase();
        }
        //return str;
    }


    public static String recurBasedOnPercent(String input, Map<String, String> map, String question) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        String query = input;
        double percent = 0.0;
        String posInp = null;
        String posOut = null;

        if(map.containsKey(input.trim()) || map.containsKey(input.trim().toLowerCase()) || map.containsKey(input.trim().toUpperCase())){
            if(map.containsKey(input.trim())) {
                posOut = map.get(input.trim())+"";
                typeNewLine(posOut, 50);
                return input.trim().toLowerCase();
            }
            else if(map.containsKey(input.trim().toLowerCase())) {
                posOut = map.get(input.trim().toLowerCase())+"";
                typeNewLine(posOut, 50);
                return input.trim().toLowerCase();
            }
            else {
                posOut = map.get(input.trim().toUpperCase())+"";
                typeNewLine(posOut, 50);
                return input.trim().toLowerCase();
            }
        }
        else {
            for(String s: map.keySet()){
                if(CPE(input.trim().toLowerCase(), s.trim().toLowerCase()) >= percent){
                    percent = CPE(input.trim().toLowerCase(), s.trim().toLowerCase());
                    posInp = s;
                    posOut = map.get(s);
                }
            }
            pause(1000);
            typeNewLine("Did you mean " + "'"+ posInp + "'?", 20);
            pause(1000);
            query = sc.nextLine();
            pause(1000);
            if(query.trim().toLowerCase().equals("yes") || query.trim().toLowerCase().indexOf("yes") >= 0){
                posInp =  recurBasedOnPercent(posInp, map, question);
                return posInp;
            }
            else if(query.trim().toLowerCase().equals("no")|| query.trim().toLowerCase().indexOf("no") >= 0){
                pause(1000);
                typeNewLine("I'm sorry I cannot help you with your request.", 20);
                pause(500);
                typeNewLine(question, 50);
                pause(1000);
                query = sc.nextLine();
                pause(1000);
                posInp =  recurBasedOnPercent(query, map, question);
                return posInp;
            }
            else {
                pause(1000);
                typeNewLine("I couldn't understand your query.", 20);
                pause(500);
                typeNewLine(question, 20);
                pause(1000);
                query = sc.nextLine();
                posInp = recurBasedOnPercent(query, map, question);
                return posInp;
            }
            //return posInp;
        }
    }

    public static boolean checkPossibleInputs(String input, String desired1, String output1, String desired2, String output2, String question) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        boolean pass = false;
        input = input.trim().toLowerCase();
        desired1 = desired1.trim().toLowerCase();
        desired2 = desired2.trim().toLowerCase();
        if(input.equals(desired1)){
            pause(1000);
            typeNewLine(output1, 20);
            pass = true;
            return pass;
        }
        else if(input.equals(desired2)){
            pause(1000);
            typeNewLine(output2, 20);
            pass = true;
            return pass;
        }
        else if(desired1.indexOf(input) >= 0 || input.indexOf(desired1) >= 0 || CPE(input, desired1) >= 50.0){
            pause(1000);
            typeNewLine("Did you mean " + "'"+ desired1 + "'?", 20);
            String nextQuery = sc.nextLine();
            if(nextQuery.trim().toLowerCase().equals("yes")){
                pass = checkPossibleInputs(desired1, desired1, output1, desired2, output2, question);
            }
            else{
                typeNewLine("I couldn't understand your previous query. Try another input; preferably, the correct input.", 20);
                pause(500);
                typeNewLine(question, 20);
                nextQuery = sc.nextLine();
                pass = checkPossibleInputs(nextQuery, desired1, output1, desired2, output2, question);
            }
            return pass;
        }
        else if(desired2.indexOf(input) >= 0 || input.indexOf(desired2) >= 0 || CPE(input, desired2) >= 50.0){
            pause(1000);
            typeNewLine("Did you mean " + "'"+ desired2 + "'?", 20);
            String nextQuery = sc.nextLine();
            if(nextQuery.trim().toLowerCase().equals("yes")){
                pass = checkPossibleInputs(desired2, desired1, output1, desired2, output2, question);
            }
            else{
                typeNewLine("I couldn't understand your previous query. Try another input; preferably, the correct input.", 20);
                pause(500);
                typeNewLine(question, 50);
                nextQuery = sc.nextLine();
                pass = checkPossibleInputs(nextQuery, desired1, output1, desired2, output2, question);
            }
            return pass;
        }
        else {
            pause(500);
            typeNewLine("I cannot understand that query. Try the correct input.", 20);
            pause(1000);
            typeNewLine(question, 20);
            String nextQuery = sc.nextLine();
            pass = checkPossibleInputs(nextQuery, desired1, output1, desired2, output2, question);
            return pass;
        }
    }

    public static boolean checkAndSpit(String input, String desired, String output) throws InterruptedException{
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

    public void enterFolder(){
    }

    public static void main (String[] args) throws InterruptedException{
        speak("When I was a boy, I always wanted to be a play for chelsea. Chelsea is my favourite football team; therefore, all I did, as you can assume, is play football all day long.");
    }
}