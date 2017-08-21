
public class Solution125 {
	public boolean isPalindrome(String s) {
        if(s.length() == 0)
        	return true;
        s = s.toLowerCase();
        int index = 0;
        while(index < s.length() - 1){
        	if(s.charAt(index) < 97 || s.charAt(index) > 122){
        		String a = s.substring(0, index);
        		String b = s.substring(index + 1);
        		s = s.substring(0, index) + s.substring(index + 1);
        	}else
        		index++;
        }
        if(s.length() == 0 || s.length() == 1)
        	return true;
        for(int i = 0; i < s.length() / 2; i++){
        	if(s.charAt(i) != s.charAt(s.length() - i - 1))
        		return false;
        }
        return true;
    }
}
