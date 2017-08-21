
public class Solution26 {
	public int removeDuplicates(int[] nums) {
		if(nums.length <= 1)
			return nums.length;
		int[] newlist = new int[nums.length];
		int len = 0;
		newlist[0] = nums[0];
		int last = nums[0];
		len++;
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] == last)
        		continue;
        	newlist[len++] = nums[i];
        	last = nums[i];
        }
        nums = new int[len];
    	for(int i = 0; i < len; i++){
    		nums[i] = newlist[i];
    	}
    	return len;
    }
}


/**
public class Solution {
    public int removeDuplicates(int[] nums) {
        int counter = 0;
        if(nums.length == 0)
        	return 0;
        int lastnum = nums[0];
        counter++;
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] == lastnum)
        		continue;
        	lastnum = nums[i];
        	counter++;
        }
        return counter;
    }
}

**/