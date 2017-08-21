import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Solution380 {
	HashSet<Integer> record = null;
    List<Integer> list = null;
    int count = 0;
    public Solution380() {
        record = new HashSet<Integer>();
        list = new LinkedList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!record.contains(val)){
            record.add(val);
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(record.contains(val)){
            record.remove(val);
            list.remove((Object)val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random ran = new Random();
        int index = ran.nextInt(list.size());
        return list.get(index);
    }
}
