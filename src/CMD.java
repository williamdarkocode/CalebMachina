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
}