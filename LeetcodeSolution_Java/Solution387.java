import java.util.HashMap;
import java.util.Map;

public class Solution387 {
	public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;
        if(s.length() == 1)
            return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        for(int i = 0; i < s.length(); i++)
            if(map.get(s.charAt(i)) == 1)
                return i;
        return -1;
    }
	
	//Better one
	public int firstUniqChar2(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
