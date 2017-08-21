import java.util.ArrayList;
import java.util.List;


public class Solution442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length < 2)
			return res;
		for(int i = 0; i < nums.length; i++){
			while(nums[i] != i + 1){
				if(nums[nums[i] - 1] == nums[i])
					break;
				int temp = nums[i];
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}       
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != i + 1)
				res.add(nums[i]);
		}
		return res;
	}
}
