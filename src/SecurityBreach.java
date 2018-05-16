import java.util.*;
public class SecurityBreach implements Level {
    public SecurityBreach() {
    }
    
    @Override
    public String enter(Player p) throws InterruptedException{
        String nextLevelName = "ChatWithAva";
        
        
        return nextLevelName;
    }
    
    
    @Override
    public String getName() {
        return "SecurityBreach";
    }
    
    
    //@Override public
}