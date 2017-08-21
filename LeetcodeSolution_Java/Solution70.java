
public class Solution70 {
	/* Time exceeds
	 * public int climbStairs(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }*/
	public int climbStairs(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        if(n < 2)
            return num[n];
        else
            for(int i = 2; i <= n; i++)
                num[i] = num[i - 1] + num[i - 2];
        return num[n];
    }
}
