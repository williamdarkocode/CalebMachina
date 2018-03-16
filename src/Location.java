public interface Location{

    /**
     * Gets the name of the location in the text adventure game.
     * Every location in a {@link Game} should have a unique name so that an
     * {@link Engine} can properly track the state of the game.
     *
     * @return a unique identifier for each level
     */
    public String getName();

    /**
     * Causes the {@link Player} to enter the location and returns
     * the name of the next game location.
     *
     * @param p the {@link Player} entering the location
     * @return the name of the next location
     * @throws InterruptedException if the game is paused and gets interrupted
     */
    public String enter(Player p) throws InterruptedException;
}