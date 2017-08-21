
public class Solution75 {
	public void sortColors(int[] nums) {
		if(nums.length < 2)
			return;
        int rednum = 0;
        int whitenum = 0;
        int blue = 0;
        // get all the number of different color.
        for(int i = 0; i < nums.length; i++)
        	if(nums[i] == 0)
        		rednum++;
        	else if(nums[i] == 1)
        		whitenum++;
        	else
        		blue++;
        //first put all the red to the left
        int counter = 0;
        if(rednum != 0){
	        for(int i = 0; i < nums.length; i++){
	        	if(nums[i] == 0){
	        		if(i != counter){
		        		int temp = nums[i];
		        		nums[i] = nums[counter];
		        		nums[counter] = temp;
	        		}
	        		counter++;
	        	}
	        	if(counter == rednum)
	        		break;
	        }
        }
        //then in the rest aaray, put all the white to the left
        counter = rednum;
        for(int i = rednum; i < nums.length; i++){
        	if(nums[i] == 1){
        		if(i != counter){
	        		int temp = nums[i];
	        		nums[i] = nums[counter];
	        		nums[counter] = temp;
        		}
        		counter++;
        	}
        	if(counter == rednum + whitenum)
        		break;
        }
    }
}
