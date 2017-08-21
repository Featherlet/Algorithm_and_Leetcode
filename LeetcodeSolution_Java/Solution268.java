
public class Solution268 {
	public int missingNumber(int[] nums) {
        if(nums.length < 1 || nums == null)
            return 0;
        int i = 0;
        int sum = nums[0];
        for(i = 1; i < nums.length; i++)
            sum = sum ^ nums[i];
        for(i = 0; i < nums.length + 1; i++)
        	sum = sum ^ i;
        return sum;
    }
}
