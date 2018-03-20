public class DataItem extends Item{
    private String name;
    private String description;
    private int count;
    
    
    public DataItem(String name, String description, int count){
        if(count < 0){
            throw new IllegalArgumentException(
                "DataItem does not accept negative count: " + count
            );
        }
        this.name = name;
        this.description = description;
        this.count = count;
        this.count = 1;
    }
    
    public String getType(){
        return "DATA";
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
    public void use(int num)throws IllegalArgumentException{
        if(num < 0){
            throw new IllegalArgumentException("Cannot use negative amount: " + num);
        }
        this.count -= 0;
    }
      
    public void combine(Item sameKind) throws IllegalArgumentException{
        boolean sameItem = (this.name.equals(sameKind.getName()) && this.description.equals(sameKind.getDescription())) && this.getType().equals(sameKind.getType());
        if(sameItem){
            this.count+=sameKind.getCount();
            levelCount();
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