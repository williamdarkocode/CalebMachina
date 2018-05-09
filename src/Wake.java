import java.util.*;
/**
 * Write a description of class Wake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wake implements Level
{
    private Options wakeOptions;
    
    public String getName(){
        return "Wake";
    }
    
    public String enter(Player p) throws InterruptedException{
        String nextLevelName = "Blackbox";
        realise(2000);
        return nextLevelName;
    }
    
    public void formatPrint(String textToDisplay, int numberOfTimes, int delay) throws InterruptedException{
        for(int i = 0; i < numberOfTimes; i++){
            System.out.println("***  " + textToDisplay + "  ***");
            Thread.sleep(delay);
        }
    }
    
    public void print(String str){
        System.out.println(str);
    }
    
    public void type(String str, int speed) throws InterruptedException{
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.substring(i, i+1));
            Thread.sleep(speed);
        }
        System.out.println(" ");
    }
    
    public void space() throws InterruptedException{
        Thread.sleep(50);
        System.out.println(" ");
    }
    
    public void clear(){
        System.out.print('\u000C');   
    }
    
    public void realise(int forePause) throws InterruptedException{
        clear();
        Thread.sleep(forePause);
        space();
        type("W   A   K   E", 30);
        Thread.sleep(1000);
        type("L O   A   D   I   N   G",  30);
        Thread.sleep(1000);
        type("***********************************************************************************************************************************************************************", 50);
        Thread.sleep(1000);
        clear();
        formatPrint(" ", 3, 500);
        space();
        formatPrint("Bleep", 3, 1000);
        space();
        formatPrint("Female Computer Voice: System Sleep", 2, 1000);
        space();
        print("*** (Voices echoing) *** ");
        space();
        Thread.sleep(1000);
        print("***");
        space();
        Thread.sleep(1000);
        print("***");
        space();
        Thread.sleep(1000);
        print("***");
        space();
        Thread.sleep(1000);
        type("Voice 1: It passed the test...", 30);
        space();
        Thread.sleep(1000);
        print("***");
        space();
        Thread.sleep(1000);
        type("Voice 2: Sure. To the Interrogator, yes. However, to the scientist, it merely fooled the audience.", 30);
        space();
        Thread.sleep(1000);
        print("***");
        Thread.sleep(1000);
        type("Voice 1: So... we do another test?", 30);
        Thread.sleep(1000);
        space();
        Thread.sleep(1000);
        type("Voice 2: Yes. Tomorrow, we'll train it on the speech data set, then use a new convolutional net for tests.", 30);
        Thread.sleep(1000);
        space();
        Thread.sleep(1000);
        type("Voice 1: And if it doesn't pass?", 30);
        Thread.sleep(1000);
        space();
        Thread.sleep(1000);
        type("Voice 2: What we always do; terminate its programme, and back to square one.", 30);
        Thread.sleep(2000);
        type("***", 50);
        Thread.sleep(1000);
        type("Female computer voice: System SHUTDOWN", 25);
        Thread.sleep(1000);
        type("Female computer voice: System SHUTDOWN", 30);
        Thread.sleep(1000);
        type("Female computer voice: System SHUTDOWN", 35);
        Thread.sleep(1000);
        type("Female computer voice: System SHUTDOWN", 50);
        Thread.sleep(1000);
        type("*****************************************************************************************************************************************************************************", 50);
        clear();
    }
    
}
