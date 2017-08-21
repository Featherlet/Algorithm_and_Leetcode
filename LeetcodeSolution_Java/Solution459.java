
public class Solution459 {
	public boolean repeatedSubstringPattern(String str) {
        int len = 0;
        for(int i = 0; i <= str.length() / 2; i++){
            //find the length of substr
            if(str.substring(0, i).equals(str.substring(i, 2 * i))){
                len = i;
                //then check is the substr is valid
                if(i == 0 || str.length() % len != 0)
                    continue;
                int flag = 0;
                for(int j = 0; j + 2 * len <= str.length(); j+= len)
                    if(!str.substring(j, j + len).equals(str.substring(j + len, j + 2 * len)))
                        flag = 1;
                if(flag ==  0)
                    return true;
            }
        }
        return false;
    }
	
	public boolean repeatedSubstringPattern2(String str) {
		String newstr = str + str;
		newstr = newstr.substring(1, newstr.length() - 1);
		if(newstr.contains(str))
			return true;
		return false;
	}

}
