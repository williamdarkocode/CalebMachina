public class PhysicalItem extends Item{
    private String name;
    private String description;
    private int count;
    
    public PhysicalItem(String name, String description, int count){
        if(count < 0){
            throw new IllegalArgumentException(
                "PhysicalItem does not accept negative count: " + count
            );
        }
        this.name = name;
        this.description = description;
        this.count = count;
    }
    
    public String getType(){
        return "PHYSICAL";
    }
    
    private void levelCount(){
        this.count = 1;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public int getCount(){
        return this.count;
    }
    
    @Override
    public void use(int num)  throws IllegalArgumentException{
        if(num < 0){
            throw new IllegalArgumentException("Cannot use a negative amount: " + num);
        }
        else if(num<= this.count){
            this.count -= num;
        }
        else{
            throw new IllegalArgumentException("Cannot use: " + num + " more than you have " + this.count);
        }
    }
      
    public void combine(Item sameKind) throws IllegalArgumentException{
        boolean sameItem = (this.name.equals(sameKind.getName()) && this.description.equals(sameKind.getDescription())) && this.getType().equals(sameKind.getType());
        if(sameItem){
            this.count+=sameKind.getCount();
        }
        else{
            throw new IllegalArgumentException(""+this.toString() + " Is not the same as " + sameKind.toString());
        }
    }
    
    
    public String toString(){
        String str = "";
        str+= this.name + "\n";
        str+=this.description + "\n";
        str+=this.getType() + "\n";
        return str;
    }
}