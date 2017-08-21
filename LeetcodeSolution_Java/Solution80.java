
public class Solution80 {
	public int removeDuplicates(int[] nums) {
		if(nums.length < 2)
			return nums.length;
		int[] newn = nums.clone();
		for(int i = 0; i < nums.length; i++)
			newn[i] = nums[i];
		
		int index = 0;
		int count = 0;
		for(int i = 0; i < newn.length - 1;){
			if(newn[i] == newn[i + 1]){
				int j = i + 1;
				while(j < newn.length && newn[j] == newn[i])
					j++;
				nums[index++] = newn[i];
				nums[index++] = newn[i];
				count += 2;
				i = j;
			}else{
				nums[index++] = newn[i];
				count++;
				i++;
			}
		}
		if(newn[newn.length - 2] != newn[newn.length - 1]){
        	count++;
        	nums[index] = newn[newn.length - 1];
        }
		return count;
		
		/*int count = 0;
        for(int i = 0; i < nums.length - 1;){
        	if(nums[i] == nums[i + 1]){
        		int j = i + 1;
        		while(j < nums.length && nums[j] == nums[i])
        			j++;
        		count += 2;
        		i = j;
        	}else{
        		count++;
        		i++;
        	}
        }
        if(nums[nums.length - 2] != nums[nums.length - 1])
        	count++;
        return count;*/
    }
}
