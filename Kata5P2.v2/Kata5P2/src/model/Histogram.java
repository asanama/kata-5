package model;
 import java.util.HashMap;
import java.util.Map;
 public class Histogram<T>{
    
    private Map<T,Integer> count;
    
     public Histogram() {
        count = new HashMap<>();
    }
     
    public void putKey(T i){
       count.put(i,(count.containsKey(i)) ? count.get(i)+1: 1);
    }
    
    public Map<T,Integer> getMap(){
        return count ;
    }
    
    @Override
    public String toString(){
        String s = "Mapa:\n";
        int i = 0;
        for(Map.Entry<T,Integer> entry : getMap().entrySet()){
            s += entry.getKey() + " --> " + entry.getValue() + "\n";
            i+= entry.getValue();
        }
        s += "Valores: " + i;
        return s;
    }
}