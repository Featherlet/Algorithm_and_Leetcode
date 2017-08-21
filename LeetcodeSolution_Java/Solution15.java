import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3)
        	return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
        	if(i == 0 || nums[i - 1] != nums[i]){
	        	int left = i + 1; 
	        	int right = nums.length - 1; 
	        	int target = 0 - nums[i];
	        	while(left < right){
	        		if(nums[left] + nums[right] == target){
	        			res.add(Arrays.asList(nums[i], nums[left], nums[right]));
	        			while(left < right && nums[left + 1] == nums[left])left++;
	        			while(left < right && nums[right - 1] == nums[right])right--;
	        			left++;
	        			right--;
	        		}else if(nums[left] + nums[right] < target)
	        			left++;
	        		else
	        			right--;
	        	}
        	}
        }
        return res;
    }
}
