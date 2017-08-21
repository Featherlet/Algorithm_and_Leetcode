
public class Solution14 {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
        int minlen = strs[0].length();
        for(String str : strs)
        	if(str.length() < minlen)
        		minlen = str.length();
        if(minlen == 0)
        	return "";
        int index = 0;
        for(int i = 1; i <= minlen; i++){
        	for(int j = 0; j < strs.length - 1; j++){
        		String a = strs[j].substring(0, i);
        		String b = strs[j + 1].substring(0, i);
        		if(!a.equals(b))
        			if(i == 1)
        				return "";
        			else
        				return strs[j].substring(0, i - 1);
        	}
        	index = i;
        }
        return strs[0].substring(0, index);
    }
}
