import java.util.HashMap;
import java.util.*;


public class Network implements Game {

    @Override
    public Map<String, Level> getLevels(){
        Map<String, Level>  levels =  new HashMap<String,Level>();
        return levels;
    }

    @Override
    public Player getPlayer(){
        return new Caleb();
    }
}
