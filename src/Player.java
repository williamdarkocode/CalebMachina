public interface Player{

    /**
     * Gets the health of the player.
     *
     * @return the numeric health of the player
     */
    public int getHealth();

    /**
     * Changes the health of the player.
     *
     * @param delta the numeric change to the health of the player
     */
    public void changeHealth(int delta);

    /**
     * Gets the player's inventory
     *
     * @return the player's {@link Inventory}
     */
    public Inventory getInventory();
}