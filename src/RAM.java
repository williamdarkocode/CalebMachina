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
    private Map<String, Item> bag;


    public RAM(){
        bag = new HashMap<String, Item>();
    }


    private void updateInv(){
        for(Item itm: bag.values()){
            if(itm.getCount() == 0){
                bag.remove(itm.getName());
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
        if((this.bag.containsKey(i.getName())) && (this.bag.get(i.getName()).getDescription().equals(i.getDescription()))){
            this.bag.get(i.getName()).combine(i);
        }
        else{
            this.bag.put(i.getName(), i);
        }
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
        return this.bag.containsKey(itemName);
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
        if(this.bag.get(itemName) == null){
            throw new IllegalArgumentException(itemName + " does not exist in BackPack!");
        }
        else{
            return this.bag.get(itemName);
        }
    }


    public String toString(){
        updateInv();
        String str = "";
        for(Item i: bag.values()){

            str+= i.getName() + i.getCount() + "   ----    ";
        }
        return str;
    }


}