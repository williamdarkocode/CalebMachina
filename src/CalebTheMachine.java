import java.util.HashMap;
import java.util.*;


public class CalebTheMachine implements Game {

    @Override
    public List<Level> getLevels(){
       List<Level> levelsInGame = new ArrayList<Level>();
       levelsInGame.add(new Wake());
       levelsInGame.add(new Blackbox());
       levelsInGame.add(new CommandPrompt());
       return levelsInGame;
    }

    @Override
    public Player getPlayer(){
        return new Caleb();
    }
    
    @Override
    public String getName() {
        return "CalebTheMachine";
    }
}
