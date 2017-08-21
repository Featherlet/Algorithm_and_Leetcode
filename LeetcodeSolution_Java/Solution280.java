import java.util.Arrays;

public class Solution280 {
	public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2){
        	int temp = nums[i];
        	nums[i] = nums[i + 1];
        	nums[i + 1] = temp;
        }
    }

}
