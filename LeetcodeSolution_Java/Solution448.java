import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> record = new HashSet<Integer>();
        int a[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        	a[i] = nums[i];
        int i = 0;
        while(i < a.length){
        	if(a[i] == i + 1){
        		i++;
        		continue;
        	}
        	else{
        		if(a[a[i] - 1] == a[i]){
        			record.add(i + 1);
        			i++;
        		}
        		else{
        			if(record.contains(a[i]))
        				record.remove(a[i]);
        			int temp = a[i];
        			a[i] = a[temp - 1];
        			a[temp - 1] = temp;        			
        		}
        	}
        }        
        return new LinkedList<Integer>(record);
    }

}
