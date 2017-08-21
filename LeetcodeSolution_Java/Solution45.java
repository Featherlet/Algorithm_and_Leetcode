
public class Solution45 {
	//my own method
	public int jump(int[] nums) {
        //record the least index to reach the current index
		int[] reachFrom = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        	reachFrom[i] = i;
        //record the farest reached index
        int reachable = 0;
        //get all the values of reachFrom[]
        for(int i = 0; i < nums.length; i++){
        	if(reachable >= nums.length - 1)
        		break;
//        	if(reachable > i){
//        		if(reachFrom[i] > reachFrom[i - 1])
//        			reachFrom[i] = reachFrom[i - 1];        		
//        	}
        	if(reachable < nums[i] + i){
        		if(i + nums[i] < nums.length){
	        		for(int j = i; j <= i + nums[i]; j++)
	        			if(reachFrom[j] > i)
	        				reachFrom[j] = i;
        		}else{
        			for(int j = i; j < nums.length; j++)
	        			if(reachFrom[j] > i)
	        				reachFrom[j] = i;
        		}
        		reachable = Math.max(reachable, nums[i] + i);
        	}        	
        }
        //get the minimum steps.
        int step = nums.length - 1;
        int counter = 0;
        while(step > 0){
        	counter++;
        	step = reachFrom[step];
        }
        return counter;
    }
}
