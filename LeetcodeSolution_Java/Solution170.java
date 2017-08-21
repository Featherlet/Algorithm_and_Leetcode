import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Solution170 {
	HashMap<Integer, Integer> map;
	int size;
	/** Initialize your data structure here. */
    public Solution170() {
        map = new HashMap<Integer, Integer>();
        size = 0;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.containsKey(number)? map.get(number) + 1 : 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
        	Map.Entry entry = (Map.Entry)it.next();
        	int add1 = (int)entry.getKey();
        	int add2 = value - add1;
        	if((add1 == add2 && map.get(add1) > 1) || (add1 != add2 && map.containsKey(add2)))
        		return true;
        }
        return false;
    }
}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */