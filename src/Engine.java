public interface Engine{

    /**
     * Starts the Engine in the initial game state.
     * Should be called when attempting to start the game.
     *
     * @throws InterruptedException if the game is interrupted while paused
     */
    public void start() throws InterruptedException;

    /**
     * Determines if the engine has completed a game.
     * Should be used to check if the game is over before transitioning to the
     * next game state.
     * Should only be called AFTER the engine has been started via
     * {@link #start()}.
     *
     * @return true when the game is over, false otherwise
     */
    public boolean isGameDone();

    /**
     * Transitions the engine to the next game state.
     * Should only be called AFTER the engine has been started via
     * {@link #start()} AND it has been confirmed that the game is
     * NOT done via {@link isGameDone()}.
     *
     * @throws InterruptedException if game is interrupted while paused
     * @throws IllegalStateException if game is not started OR game is done
     */
    public void goToNextLevel() throws InterruptedException,
            IllegalStateException;
}