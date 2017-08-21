import java.util.ArrayList;

public class Solution7 {
	
	public int reverse(int x) {
		int max = 0x7fffffff; 
	    int min = 0x80000000;
        int num = x;
        long newX = 0;
        while(num != 0){
        	int temp = num % 10;
        	num /= 10; 	
        	newX = newX * 10 + temp;
        	if(newX > max || newX < min)
        		return 0;
        }
        return (int)newX;
    }
}
