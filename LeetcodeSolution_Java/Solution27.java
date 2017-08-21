
public class Solution27 {
	public int removeElement(int[] nums, int val) {
        int initlen = nums.length;
        int[] oldnums = new int[initlen];
        for(int i = 0; i < initlen; i++){
        	oldnums[i] = nums[i];
        }
        int counter = 0;
        for(int n : oldnums){
        	if(n == val)
        		continue;
        	nums[counter] = n;
        	counter++;
        }
        return counter;
    }
}
