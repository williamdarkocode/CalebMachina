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
        String nextLevelName = "";
        realise(2000);
        return nextLevelName;
    }
    
    public void formatPrint(String textToDisplay, int numberOfTimes, int delay) throws InterruptedException{
        for(int i = 0; i < numberOfTimes; i++){
            System.out.println("***  " + textToDisplay + "  ***");
            Thread.sleep(delay);
        }
    }
    
    
    public void realise(int forePause) throws InterruptedException{
        Thread.sleep(forePause);
        formatPrint("Bleep", 3, 1000);
    }
    
}
