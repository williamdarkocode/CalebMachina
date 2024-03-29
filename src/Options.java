import java.util.*;

public class Options{
    private List<String> optionsList;
    private Map opsMap;
    
    
    public Options(){
        this.optionsList = new ArrayList<String>();
        this.opsMap = new HashMap<String, String>();
    }
    
    
    public Map getOptions(){
        return this.opsMap;
    }
    
    
    public String getSingleOption(int idx){
        return this.opsMap.get(this.opsMap.keySet().toArray()[idx])+"";
    }
    
    public void resetOptions(Map<String, String> newOptionsSet){
        this.opsMap = newOptionsSet;
    }
    
    public void clearOptionSet(){
        opsMap = new HashMap<String, String>();
    }
    
    
    public void addOption(String key, String val){
        this.opsMap.put(key, val);
    }
    
    public void removeOption(int idx){
        this.opsMap.remove(this.opsMap.keySet().toArray()[idx], this.opsMap.get(this.opsMap.keySet().toArray()[idx]));
    }
    
    public void changeOption(int idx, String newVal){
        String key = this.opsMap.keySet().toArray()[idx]+"";
        this.opsMap.remove(key);
        this.opsMap.put(key, newVal);
        //this.opsMap.replace(key, this.opsMap.get(key),newVal);
    }
    
    
    public String displayOptions(){
        String display = "" + "\n";
        for(int i = 0; i < this.opsMap.keySet().size(); i++){
            display+= "***  " + i + ") " + this.opsMap.keySet().toArray()[i] + "  ***" + "\n";
        }
        return display;
    }
    
}