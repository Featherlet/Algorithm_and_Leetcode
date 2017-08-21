import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution350 {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for(int n : nums1)
        	map1.put(n, map1.getOrDefault(n, 0) + 1);
        for(int n : nums2)
        	map2.put(n, map2.getOrDefault(n, 0) + 1);
        List<Integer> list = new ArrayList<Integer>();
        for(int num : map1.keySet()){
        	if(map2.containsKey(num)){
        		int count1 = map1.get(num);
        		int count2 = map2.get(num);
        		int count = Math.min(count1, count2);
        		for(int i = 0; i < count; i++)
        			list.add(num);
        	}
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        	res[i] = list.get(i);
        return res;
    }
}
