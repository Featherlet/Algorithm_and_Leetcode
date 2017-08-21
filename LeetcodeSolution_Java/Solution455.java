import java.util.Arrays;

public class Solution455 {
	public int findContentChildren(int[] g, int[] s) {
        //sort g and s first
		Arrays.sort(g);
		Arrays.sort(s);
		int ig = 0;
        int is = 0;
        int counter = 0;
		while(ig < g.length && is < s.length){
        	if(s[is] >= g[ig]){
        		counter++;
        		is++;
        		ig++;
        	}else{
        		is++;
        	}
        }
		return counter;
    }
	
	
}
