
public class QuickSort {

	public void quicksort(int[] a){
		subsort(a, 0, a.length - 1);
	}
	
	public void subsort(int[] a, int start, int end){
		if(a == null || (end - start < 1))
			return;
		int index = findMid(a, start, end);
		if(index == start)
			subsort(a, index + 1, end);
		else if(index == end)
			subsort(a, start, index - 1);
		else{
			subsort(a, start, index - 1);
			subsort(a, index + 1, end);
		}
	}
	
	public int findMid(int[] a, int low, int high){
		int value = a[low];
		while(low < high){
			while(low < high && a[high] >= value)
				high--;
			a[low] = a[high];
			while(low < high && a[low] <= value)
				low++;
			a[high] = a[low];
		}
		a[low] = value;
		return low;
	}
}
