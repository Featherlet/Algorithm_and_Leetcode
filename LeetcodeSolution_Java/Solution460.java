import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Solution460 {
    Map<Integer, Integer> frequence = null;
    Map<Integer, Integer> cache = null;
    Map<Integer, LinkedHashSet<Integer>> lists = null;
    int min = -1;
    int counter = 0;
    int capacity = 0;
    
    public Solution460(int capacity) {
        frequence = new HashMap<Integer, Integer>();
        cache = new HashMap<Integer, Integer>();
        this.capacity = capacity;
        lists = new HashMap<Integer, LinkedHashSet<Integer>>();
        lists.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        int count = frequence.get(key);
        lists.get(count).remove(key);
        //if the list of frequecy count is empty now
        if(count == min && lists.get(min).size() == 0)
            min++;
        if(!lists.containsKey(count + 1))
            lists.put(count + 1, new LinkedHashSet<Integer>());
        lists.get(count + 1).add(key);
        frequence.put(key, count + 1);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
    	if(capacity == 0)
    		return;
        if(!cache.containsKey(key)){
            frequence.put(key, 1);
            cache.put(key, value);
            lists.get(1).add(key);
            counter++;
            if(counter > capacity){
                int delId = lists.get(min).iterator().next();
                lists.get(min).remove(delId);
                frequence.remove(delId);
                cache.remove(delId);
                counter--;
            }
        }else{
            cache.put(key, value);
            get(key);
        }
        min = 1;
    }
}
