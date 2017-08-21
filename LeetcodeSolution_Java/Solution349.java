import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        List<Integer> list = new ArrayList<Integer>();
        for(int n : nums1){
        	if(!set.contains(n))
        		set.add(n);
        }
        for(int n : nums2){
        	if(set.contains(n) && !list.contains(n))
        		list.add(n);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        	res[i] = list.get(i);
        return res;
    }
}
