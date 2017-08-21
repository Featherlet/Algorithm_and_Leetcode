
public class MergeSort {
	
	public void mergesort(int[] a){
		subsort(a, 0, a.length - 1);
	}
	
	public void subsort(int[] a, int first, int last){
		if(first < last){
			int mid = (first + last) / 2;
			subsort(a, first, mid);
			subsort(a, mid + 1, last);
			merge(a, first, mid, last);
		}
	}
	public int[] merge(int[] a, int first, int mid, int last){
		int[] p = new int[last - first + 1];
		int i = first, j = mid + 1, k = 0;
		while(i <= mid && j <= last){
			if(a[i] <= a[j])
				p[k++] = a[i++];
			else
				p[k++] = a[j++];
		}
		while(i <= mid)
			p[k++] = a[i++];
		while(j <= last)
			p[k++] = a[j++];
		for(i = 0; i < p.length; i++)
			a[first + i] = p[i];
		return p;
	}
	
	
}
