import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution242 {
	public boolean isAnagram(String s, String t) {
		if(s.length() == 0){
			if(t.length() == 0)
				return true;
			else
				return false;
		}
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
        	if(map1.containsKey(s.charAt(i))){
        		int value = map1.get(s.charAt(i)) + 1;
        		map1.put(s.charAt(i), value);
        	}else{
        		map1.put(s.charAt(i), 1);
        	}
        }
        for(int i = 0; i < t.length(); i++){
        	if(map2.containsKey(t.charAt(i))){
        		int value = map2.get(t.charAt(i)) + 1;
        		map2.put(t.charAt(i), value);
        	}else{
        		map2.put(t.charAt(i), 1);
        	}
        }
        Iterator it = map1.entrySet().iterator();
        while(it.hasNext()){
        	HashMap.Entry pair = (HashMap.Entry)it.next();
        	if(!map2.containsKey(pair.getKey()))
        		return false;
        	int value = map2.get(pair.getKey());
        	if(value != (int)pair.getValue())
        		return false;
        }
        it = map2.entrySet().iterator();
        while(it.hasNext()){
        	HashMap.Entry pair = (HashMap.Entry)it.next();
        	if(!map1.containsKey(pair.getKey()))
        		return false;
        }
        return true;
    }
}
