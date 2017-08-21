

public class Solution55 {
	public boolean canJump(int[] nums) {
		if(nums.length == 0)
			return false;
		//record the right most index that can be reached by the previous step
		int reachable = 0;
		for(int i = 0; i < nums.length; i++){
			//if no step can reach this index, return false
			if(i > reachable)
				return false;
			//else update the index
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
    }
}
