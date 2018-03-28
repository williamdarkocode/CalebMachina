import java.util.*;

public class Options{
    private List<String> optionsList;
    
    
    public Options(List<String> optionsList){
        this.optionsList = optionsList;
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
    
    
    public String displayOptions(){
        String display = "";
        for(int i = 0; i < this.optionsList.size(); i++){
            display+= "***  " + i + ") " + this.optionsList.get(i) + "  ***";
        }
        return display;
    }
    
}