import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            while(!q.isEmpty() && (q.peek() < i - k + 1))
                q.poll();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            q.add(i);
            if(i >= k - 1)
                res[index++] = nums[q.peekFirst()];
        }
        return res;
    }
}
