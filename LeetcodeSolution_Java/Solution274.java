import java.util.Arrays;
import java.util.Collections;

public class Solution274 {
	public int hIndex(int[] citations) {
		if(citations.length == 0)
			return 0;
		if(citations.length == 1)
			if(citations[0] == 0)
				return 0;
			else
				return 1;
		Arrays.sort(citations);
		int h = 0;
		int len = citations.length;
		for(int i = 0; i < len; i++){
			if(len - i <= citations[i]){
				h = len - i > h ? len - i : h;
			}
		}
		return h;
    }
}
