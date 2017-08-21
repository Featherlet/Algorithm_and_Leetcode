import java.util.Arrays;

public class Solution324 {
	public void wiggleSort(int[] nums) {
        if(nums.length < 2)
        	return;
        int[] newnums = nums.clone();
        Arrays.sort(newnums);
        for(int i = nums.length - 1, j = 0, k = i / 2 + 1; i >= 0; i--){
        	nums[i] = newnums[(i % 2) == 0 ? j++ : k++];
        }
    }

}
