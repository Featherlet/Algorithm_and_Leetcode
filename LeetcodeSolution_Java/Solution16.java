import java.util.Arrays;

public class Solution16 {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closed = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
        	if(i == 0 || nums[i - 1] != nums[i]){
        		int left = i + 1, right = nums.length - 1;
        		while(left < right){
	        		int newsum = nums[i] + nums[left] + nums[right];
	        		if(Math.abs(target - newsum) < Math.abs(target - closed))
	        			closed = newsum;
	        		else if(newsum > target)
	        			right--;
	        		else
	        			left++;
        		}
        	}
        }
        return closed;
    }

}
