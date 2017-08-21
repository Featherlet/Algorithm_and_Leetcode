import java.util.Arrays;
import java.util.Comparator;

//This problem I learned new method: 
//how to sort data structure using Arrays.sorting by Comparator

public class Solution435 {
	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals.length < 2)
			return 0;
		//first sort intervals by end time. If there are two intervals with the same end time, 
		//then sort by start time
		sortIntervals(intervals);
		//counter is the time of overlapping occurrence.
		int counter = 0;
		//area is the checked area with no overlapping.
		int[] area = {intervals[0].start, intervals[0].end};
		for(int i = 1; i < intervals.length; i++){
			if(isOverlapped(area[0], area[1], intervals[i].start, intervals[i].end)){
				counter++;
			}else{
				//if there are no overlapping area, enlarge the area
				area[1] = intervals[i].end;
			}
		}
        return counter;
    }
	
	private boolean isOverlapped(int a1, int a2, int b1, int b2){
		if(a2 <= b1 || b2 <= a1)
			return false;
		return true;
	}
	
	public void sortIntervals(Interval[] intervals){
		Comparator cmp = new MyComparator();
		Arrays.sort(intervals, cmp);
	}
	private class MyComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval o1, Interval o2) {
			//
			if(o1.end < o2.end) { 
				return -1;
			}else if(o1.end == o2.end) {
				if(o1.start < o2.start)
					return -1;
				else if(o1.start == o2.start)
					return 0;
				else
					return 1;
			}else {
				return 1;
			}
		}
	}
}
