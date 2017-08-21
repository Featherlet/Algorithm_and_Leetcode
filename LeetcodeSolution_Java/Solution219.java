import java.util.HashSet;
import java.util.Set;

public class Solution219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length < 2)
            return false;
        //method 2
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(i > k)
        		set.remove(nums[i - k - 1]);
        	if(set.contains(nums[i]))
        		return true;
        }
        return false;
        
        /*my method, time exceeded
         * for(int i = 0; i < nums.length; i++){
        	int j = i + 1;
            while(j - i <= k && j < nums.length){
                if(nums[i] == nums[j])
                    return true;
                j++;
            }
        }
        return false;
        */
        
    }
}
