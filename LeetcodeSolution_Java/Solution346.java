import java.util.LinkedList;
import java.util.Queue;

public class Solution346 {

	Queue<Integer> queue = null;
	int size = 0;
	/** Initialize your data structure here. */
    public Solution346(int size) {
    	queue = new LinkedList<Integer>();
    	this.size = size;
    }
    
    public double next(int val) {
        if(queue.size() < size)
        	queue.offer(val);
        else{
        	queue.poll();
        	queue.offer(val);
        }
        int sum = 0;
        for(int i = 0; i < queue.size(); i++){
        	int num = queue.poll();
        	sum += num;
        	queue.offer(num);
        }
        return sum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
