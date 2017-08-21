import java.util.HashSet;
import java.util.Set;

public class Solution264 {
	public int nthUglyNumber(int n) {
        if(n < 6)
        	return n;
        //factors
        int f2 = 2, f3 = 3, f5 = 5;
        //indices
        int id2 = 0, id3 = 0, id5 = 0;
        int[] uglynums = new int[n];
        uglynums[0] = 1;
        for(int i = 1; i < n; i++){
        	int min = Math.min(f2, Math.min(f3, f5));
        	uglynums[i] = min;
        	if(f2 == min)
        		f2 = 2 * uglynums[++id2];
        	if(f3 == min)
        		f3 = 3 * uglynums[++id3];
        	if(f5 == min)
        		f5 = 5 * uglynums[++id5];
        }
        return uglynums[n - 1];
    }
	
}
