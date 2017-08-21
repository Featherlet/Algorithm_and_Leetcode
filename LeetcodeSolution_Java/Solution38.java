
public class Solution38 {
	public String countAndSay(int n) {
        if(n == 1)
        	return "1";
        else{
        	String last = countAndSay(n - 1);
        	int i = 0;
        	String current = "";
        	while(i < last.length()){
        		if(i == last.length() - 1){
        			current += "1" + last.charAt(i);
        			return current;
        		}
        		//start from location i
        		int count = 1;
        		int j = i + 1;
        		for(; j < last.length(); j++){
        			if(last.charAt(j) != last.charAt(i)){
        				break;
        			}else
        				count++;
        		}
        		current += Integer.toString(count) + last.charAt(i);
				i = j ;
        	}
        	return current;
        }
    }
}
