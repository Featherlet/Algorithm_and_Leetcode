import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		//using hashmap and buscket
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);
		ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
		for(int n : map.keySet()){
			int count = map.get(n);
			if(bucket[count] == null){
				bucket[count] = new ArrayList<Integer>();
				bucket[count].add(n);
			}
			else
				bucket[count].add(n);
		}
		List<Integer> res = new ArrayList<Integer>();
		int counter = 0;
		for(int i = bucket.length - 1; i >= 0 && counter < k; i--){
			if(bucket[i] != null){
				for(int j = 0; j < bucket[i].size(); j++){
					res.add(bucket[i].get(j));
					counter++;
					if(counter == k)
						break;
				}
			}
		}
		return res;
    }
}
