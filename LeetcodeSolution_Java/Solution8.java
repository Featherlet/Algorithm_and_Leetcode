
public class Solution8 {
	public int myAtoi(String str) {
        while(str.startsWith(" "))
        	str = str.substring(1);
        if(str.isEmpty())
        	return 0;
        int flag = 1;
        if(str.startsWith("+")){
        	str = str.substring(1);
        }else if(str.startsWith("-")){
        	flag = 0;
        	str = str.substring(1);
        }
        if(str.isEmpty())
        	return 0;
        if(str.charAt(0) < 48 || str.charAt(0) > 57)
        	return 0;
        while(str.startsWith("0"))
        	str = str.substring(1);
        int max = 0x7fffffff; 
	    int min = 0x80000000;
        int[] integer = new int[str.length()];
        int length = 0;;
        for(int i = 0; i < str.length(); i++){
        	if(str.charAt(i)>= 48 && str.charAt(i) <= 57){
        		integer[i] = str.charAt(i) - '0';
        		length++;
        	}else
        		break;
        }
        long sum = 0;
        for(int i = 0; i < length; i++){
        	sum = sum * 10 + integer[i];
        	if(sum > max || sum < min){
        		if(flag == 0)
        			return min;
        		else
        			return max;
        	}
        }
        if(flag == 1)
        	return (int)sum;
        else
        	return -(int)sum;
    }
}
