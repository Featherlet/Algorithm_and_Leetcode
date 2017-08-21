
public class Solution28 {
	public int strStr(String haystack, String needle) {
		if(needle.length() == 0)
			return 0;
		if(haystack.length() == 0)
			return -1;
		int[] T = getT(needle);
		int begin = 0;
    	int index = 0;
    	while(begin + index < haystack.length()){
    		if(haystack.charAt(begin + index) == needle.charAt(index))
    			if(index == needle.length() - 1)
    				return begin;
    			else
    				index++;
    		else{
    			if(T[index] >= 0){
    				begin = begin + index - T[index];
    				index = T[index];
    			}else
    				begin++;
    				index = 0;
    		}
    	}
    	return -1;
    }
	private int[] getT(String p){
		int index;
		int[] T = new int[p.length()];
		T[0] = -1;
		for(int i = 1; i < p.length(); i++){
			index = T[i - 1];
			while(index >= 0 && p.charAt(i) != p.charAt(index + 1))
				index = T[index];
			if(p.charAt(i) == p.charAt(index + 1))
				T[i] = index + 1;
			else
				T[i] = -1;
		}
		return T;
	}
	
}
