import java.util.List;
/**
 * Write a description of class AFSEBackpack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class RAM implements Inventory
{
    private Map<String, Item> ram;


    public RAM(){
        ram = new HashMap<String, Item>();
    }


    private void updateInv(){
        for(Item itm: ram.values()){
            if(itm.getCount() == 0){
                ram.remove(itm.getName());
            }
        }
    }


    /**
     * Adds an {@link Item} to the inventory
     *
     * @param i the {@link Item} to be added to the inventory
     */
    public void addItem(Item i)
    {
        updateInv();
        Item itemInRAM = this.ram.get(i.getName());
        boolean sameItem = (itemInRAM.getName().equals(i.getName())) && (itemInRAM.getDescription().equals(i.getDescription())) && (itemInRAM.getType().equals(i.getType()));
        if(this.ram.containsKey(i.getName()) && sameItem){
            this.ram.get(i.getName()).combine(i);
        }
        else{
            this.ram.put(i.getName(),i);
        }
        updateInv();
    }

    /**
     * Determines whether or not an {@link Item} with the itemName is in the
     * inventory
     *
     * @param itemName the name of the item
     * @return true if an item with itemName is in the inventory, false
     *         otherwise
     */
    public boolean hasItem(String itemName)
    {
        updateInv();
        return this.ram.containsKey(itemName);
    }

    /**
     * Gets an {@link Item} with itemName from the inventory, provided it
     * exists in the inventory.
     *
     * @param itemName the name of the item
     * @return an {@link Item} that has the corresponding itemName, null if
     *         no such {@link Item} exists
     */
    public Item getItem(String itemName) throws IllegalArgumentException
    {
        updateInv();
        if(this.ram.get(itemName) == null){
            throw new IllegalArgumentException(itemName + " does not exist in RAM!");
        }
        else{
            return this.ram.get(itemName);
        }
    }


    public String toString(){
        updateInv();
        String str = "";
        for(Item i: ram.values()){

            str+= i.getName() + i.getCount() + "   ----    ";
        }
        return str;
    }


}