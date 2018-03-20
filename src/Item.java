public abstract class Item{

    /**
     * Gets the name of the item in the text adventure game.
     *
     * @return the name of the item
     */
    abstract String getName();

    /**
     * Gets the description of the item in the text adventure game.
     *
     * @return the description of the item
     */
    abstract String getDescription();

    /**
     * Gets the count of how many instances of the item there are.
     * For example, a pack of gum item might have 5 pieces of gum.
     *
     * @return the number of instances in this item
     */
    abstract int getCount();

    /**
     * Uses a positive number of instances of the item.
     *
     * @param positiveNum a positive number of items to use
     * @throws IllegalArgumentException if positive num is non-positive OR
     *         exceeds the count of instances of the item
     */
    abstract void use(int positiveNum) throws IllegalArgumentException;
    
    abstract String getType();

    /**
     * Combines two items of the same kind into one.
     * Items of the same kind have the same name and description.
     *
     * @param sameKindOfItem an item that has the same name and description
     *        as this item
     * @throws IllegalArgumentException if sameKindOfItem does not have
     *         the same name as this item OR does not have the same description
     *         as this item
     */
    public void combine(Item sameKind) throws IllegalArgumentException{
        if(!sameKind.getName().equals(this.getName())){
            throw new IllegalArgumentException("sameKind { " +
                    sameKind + " }\n" +
                    "does not have the same name " +
                    "as this item { " + this +
                    " }");
        }
        else if(!sameKind.getDescription().equals(this.getDescription())){
            throw new IllegalArgumentException("sameKind { " +
                    sameKind + " }\n" +
                    "does not have the same " +
                    "description as this item { " +
                    this + " }");
        }
        // Actual combination to be implemented by subclass
    }

    @Override
    public String toString(){
        return
                "*Item Information*\n" +
                        "Name:{ " + getName() + " };\n" +
                        "Description:{ " + getDescription() + " };\n" +
                        "Count:{ " + getCount() + " };\n";
    }
}