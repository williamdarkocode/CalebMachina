public class Caleb implements Player{
    private Inventory playerInventory = new RAM();
    private int health;
    private String playerName;


    public Caleb(){
        //this.playerInventory = playerInventory;
        this.health = 100;
        this.playerName = "Caleb";
    }




    public int getHealth(){
        return this.health;
    }


    public void changeHealth(int deltaHealth){
        this.health+=deltaHealth;
    }


    public Inventory getInventory(){
        return playerInventory;
    }
}
