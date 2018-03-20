import java.util.*;

public class Levels {
    private Map<String, Level> levels;
    private List<Level> gameLevels;

    public Levels(List<Level> levelsInGame) {
        levels = new HashMap<String, Level>();
        for (Level l : gameLevels) {
            levels.put(l.getName(), l);
        }
    }


    public void addLevel(Level l) {
        levels.put(l.getName(), l);
    }


    public Map<String, Level> getLevelsInGame() {
        return levels;
    }


    public Level getLevel(String levelName) {
        return levels.get(levelName);
    }


    public void removeLevel(String levelName) {
        levels.remove(levelName);
    }


}

