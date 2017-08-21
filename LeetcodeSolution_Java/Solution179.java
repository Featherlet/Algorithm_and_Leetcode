
public class Solution179 {
	public String largestNumber(int[] nums) {
		int flag = 0;
		for(int i = 0; i < nums.length; i++)
			if(nums[i] > 0){
				flag = 1;
				break;
			}
		if(flag == 0)
			return "0";
        //sort all numbers according to their hightest position number
		for(int i = 0; i < nums.length; i++){
        	int max_index = i;
        	for(int j = i; j < nums.length; j++){
        		//nums[j] > nums[max_index]
        		if(nums[j] == nums[max_index])
        			continue;
        		if(specialCompare(nums[j], nums[max_index]) == true)
        			max_index = j;
        	}
        	int temp = nums[i];
        	nums[i] = nums[max_index];
        	nums[max_index] = temp;
        }
		String res = "";
		for(int i = 0; i < nums.length; i++){
			res += Integer.toString(nums[i]);
		}
		return res;
    }
	
	public boolean specialCompare(int n1, int n2){
		int count1 = 0;
		int count2 = 0;
		int a = n1, b = n2;
		while(a > 0){
			count1++;
			a /= 10;
		}
		if(n1 == 0)
			count1 = 1;
		while(b > 0){
			count2++;
			b /= 10;
		}
		if((n1 * Math.pow(10, count2) + n2) >= (n2 * Math.pow(10, count1) + n1))
			return true;
		else
			return false;
	}
	
	/*public boolean specialCompare(int n1, int n2){
		int count1 = 0;
		int count2 = 0;
		int a = n1, b = n2;
		while(a > 0){
			count1++;
			a /= 10;
		}
		while(b > 0){
			count2++;
			b /= 10;
		}
		int count = count1 > count2 ? count1 : count2;
		int[] ary1 = new int[count];
		int[] ary2 = new int[count];
		a = n1;
		b = n2;
		int i = 0;
		while(a > 0){
			ary1[count1 - 1 - i] = a % 10;
			a /= 10;
			i++;
		}
		i = 0;
		while(b > 0){
			ary2[count2 - 1 - i] = b % 10;
			b /= 10;
			i++;
		}
		i = 0;
		while(i < count){
			if(ary1[i] > ary2[i])
				return true;
			else if(ary1[i] < ary2[i])
				return false;
			i++;
		}
		if(count1 < count2)
			return true;
		else
			return false;
	}*/
}
