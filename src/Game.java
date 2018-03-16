import java.util.List;

/**
 * Representation of a text adventure game. Games are given to an
 * {@link Engine} in order to be played.
 * @author Sean Stern
 * @version 1.0
 */
public interface Game{

    /**
     * Gets a list of all the the locations in the game
     *
     * @return a list of all the locations in the game
     * @see Location
     */
    public List<Location> getLocations();

    /**
     * Get the player for the game
     *
     * @return a player for the game
     * @see Player
     */
    public Player getPlayer();
}