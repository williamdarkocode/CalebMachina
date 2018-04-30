import java.util.*;
import java.util.List;

public class ComplexEngine implements Engine{
    private Player player;
    private List<Level> levelsInGame;
    private Map<String, Level> levelsMap;
    private Map<String, Level> trackerMap;
    //private Level level;
    //private Game curGame;
    private String nextLevelName;


    public ComplexEngine(Game g){
        player = g.getPlayer();
        levelsInGame = g.getLevels();
        Map mappedLevels = new HashMap<String, Level>();
        for (Level l : levelsInGame) {
            mappedLevels.put(l.getName(), l);
        }
        levelsMap = mappedLevels;
        trackerMap = new HashMap<String, Level>();
        nextLevelName = null;
    }

    public String getNextLevelName(){
        return nextLevelName;
    }

    @Override
    public void start() throws InterruptedException{
        Level levelOne = levelsInGame.get(0);
        nextLevelName = levelOne.enter(player);
        trackerMap.put(levelOne.getName(), levelOne);
    }

    public boolean isGameDone(){
        return trackerMap.containsKey("EndLevel");
    }

    @Override
    public void goToNextLevel() throws InterruptedException, IllegalStateException{
        if(levelsMap.containsKey(nextLevelName)){
            trackerMap.put(nextLevelName, levelsMap.get(nextLevelName));
            Level nextLevel = levelsMap.get(nextLevelName);
            nextLevelName = nextLevel.enter(player);
        }
        throw new IllegalStateException("Level '" + nextLevelName + "'" +
                " is not defined for game.");
    }



    @Override
    public String toString(){
        String engineInfo;
        engineInfo =
                "*SimpleEngine Information*\n" +
                        "Player:{ " + player.toString() + " };\n" +
                        "Next Location:{ " + nextLevelName + " };\n";
        engineInfo += "All Locations:{ ";
        for(Level l : levelsInGame){
            engineInfo += l.getName() + " ";
        }
        engineInfo += "};\n";
        return engineInfo;
    }


}
