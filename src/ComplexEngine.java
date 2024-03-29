import java.util.*;
import java.util.List;

public class ComplexEngine implements Engine{
    private Player player;
    private List<Level> levelsInGame;
    private Map<String, Level> levelsMap;

    private String nextLevelName;

    public ComplexEngine(Game g){
        player = g.getPlayer();
        levelsInGame = g.getLevels();
        Map mappedLevels = new HashMap<String, Level>();
        for (Level l : levelsInGame) {
            mappedLevels.put(l.getName(), l);
        }
        levelsMap = mappedLevels;
        nextLevelName = null;
    }

    public String getNextLevelName(){
        return nextLevelName;
    }

    @Override
    public void start() throws InterruptedException{
        Level levelOne = levelsInGame.get(0);
        nextLevelName = levelOne.enter(player);
    }

    public boolean isGameDone(){
        return nextLevelName == null;
    }

    @Override
    public void goToNextLevel() throws InterruptedException, IllegalStateException{
        if(levelsMap.containsKey(nextLevelName)){
            Level nextLevel = levelsMap.get(nextLevelName);
            nextLevelName = nextLevel.enter(player);
        }
        else {
            System.out.println(levelsMap.keySet().toString() + nextLevelName);
            throw new IllegalStateException("Level '" + nextLevelName + "'" +
                " is not defined for game.");
        }
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
