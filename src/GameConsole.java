import java.util.*;
/**
 * A text adventure console that binds together an {@link Engine} and a
 * {@link Game}. 
 * @author Sean Stern
 * @version 1.0
 */
public class GameConsole{
    private List<Game> games;
    private Game currentGame;

    /**
     * Creates a predetermined {@link Game}, inserts it into an {@link Engine}
     * and plays the game.
     *
     * @throws InterruptedException if the game is interrupted while paused
     */
    public GameConsole(List<Game> games) throws InterruptedException{
        this.games = games;
        currentGame = selectGame();
        Engine e = new ComplexEngine(currentGame);
        e.start();
        while(!e.isGameDone()){
            e.goToNextLevel();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        GameConsole console = new GameConsole(myGames());
    }

    public static List<Game> myGames(){
        List<Game> myGames = new ArrayList<Game>();
        myGames.add(new CalebTheMachine());
        return myGames;
    }

    private Game selectGame(){
        Scanner sc = new Scanner(System.in);
        String gameName = "";
        System.out.println("Select the game you want to play");
        for(int i = 0; i < games.size(); i++){
            System.out.println(games.get(i).getName());
        }
        String userInput = sc.next().toLowerCase();
        for(int i = 0; i < games.size(); i++){
            if(userInput.equals(games.get(i).getName().toLowerCase())){
                gameName = userInput;
                return games.get(i);
            }
        }
        System.out.println("Console: No game selected.");
        return selectGame();
    }
}