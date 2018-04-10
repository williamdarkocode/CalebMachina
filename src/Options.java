import java.util.*;

public class Options{
    private List<String> optionsList;
    
    
    public Options(){
        this.optionsList = new ArrayList<String>();
    }
    
    
    public List<String> getOptions(){
        return this.optionsList;
    }
    
    
    public String getSingleOption(int idx){
        return this.optionsList.get(idx);
    }
    
    public void resetOptions(List<String> newOptionsSet){
        this.optionsList = newOptionsSet;
    }
    
    public void changeSingeOption(String newOption, int idx){
        this.optionsList.remove(idx);
        this.optionsList.add(idx-1, newOption);
    }
    
    public void addOption(String op){
        optionsList.add(op);
    }
    
    
    public String displayOptions(){
        String display = "";
        for(int i = 0; i < this.optionsList.size(); i++){
            display+= "***  " + i + ") " + this.optionsList.get(i) + "  ***";
        }
        return display;
    }
    
}