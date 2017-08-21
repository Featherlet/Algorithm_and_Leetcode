
public class Solution9 {
	public boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		if(x < 10)
			return true;
		int t = x;
		int d = 0; //d is the bit number
		while(t != 0){
			t /= 10;
			d++;
		}
        int right = (int)Math.pow(10, (double)d - 1);
        int left = 1;
        for(int i = 0; i < d / 2; i++){
        	if(x / right % 10 != x / left % 10)
        		return false;
        	right /= 10;
        	left *= 10;
        }
        return true;
    }
}
