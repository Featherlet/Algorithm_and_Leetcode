import java.util.ArrayList;
import java.util.List;

public class Solution438 {
	/*public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(s == null || s.length() < p.length())
            return list;
        int window = p.length();
        for(int i = 0; i + window - 1 < s.length(); i++){
            if(isAnagrams(s.substring(i, i + window),p))
                list.add(i);
        }
        return list;
    }
	
	private boolean isAnagrams(String a, String b){
		if(a.length() != b.length())
			return false;
		int[] list1 = new int[26];
		int[] list2 = new int[26];
		for(int i = 0; i < a.length(); i++){
			list1[a.charAt(i) - 'a']++;
			list2[b.charAt(i) - 'a']++;
		}
		for(int i = 0; i < 26; i++)
			if(list1[i] != list2[i])
				return false;
		return true;
	}*/
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[256]; //character hash
	    //record each character in p to hash
	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }
	    //two points, initialize count to p's length
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, decrease the count
	        //current hash value >= 1 means the character is existing in p
	        if (hash[s.charAt(right++)]-- >= 1) count--; 
	        
	        //when the count is down to 0, means we found the right anagram
	        //then add window's left to result list
	        if (count == 0) list.add(left);
	    
	        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
	        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
	    }
	    return list;
    }
}
