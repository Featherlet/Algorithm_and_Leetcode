
public class RadixSort {
	public void radixsort(int[] a, int num){
		int n = 1;
		int d = 1; //which digit now
		int[][] buckets = new int[10][a.length];
		int[] counts = new int[10];
		while(d <= num){
			for(int i = 0; i < a.length; i++){
				int id = (a[i] / n) % 10;
				buckets[id][counts[id]] = a[i];
				counts[id]++;
			}
			int k = 0;
			for(int i = 0; i < 10; i++){
				if(counts[i] != 0){
					for(int j = 0; j < counts[i]; j++)
						a[k++] = buckets[i][j];
				}
				counts[i] = 0;
			}
			n *= 10;
			d++;
		}		
	}
}
