
public class Solution53 {
	public int maxSubArray(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++){
        	sum += nums[i - 1];
            max = Math.max(max, sum);
            if(sum < 0)
            	sum = 0;
        }
        return max;
    }
}
