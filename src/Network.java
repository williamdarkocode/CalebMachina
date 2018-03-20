import java.util.HashMap;
import java.util.*;


public class Network implements Game {

    @Override
    public List<Level> getLevels(){
       List<Level> levelsInGame = new ArrayList<Level>();
       return levelsInGame;
    }

    @Override
    public Player getPlayer(){
        return new Caleb();
    }
}
