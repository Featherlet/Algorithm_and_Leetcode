import java.util.ArrayList;

//1 2 3 4 5 6 7 8 9 10 11 12
//1 1 2 1 2 2 3 1 2  2 3  2
public class Solution338 {
	
	/*public ArrayList<Integer> countBits(int num) {  
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        ret.add(1);
        int cnt = 1;  
        while(cnt < num) {  
            int sz = ret.size();  
            for(int i = 0; i < sz && cnt < num; ++i,++cnt) {  
                ret.add(ret.get(i)+1);  
            }  
        }  
        return ret;  
    }   */
	
	public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if(num < 1)
            return res;
        else
            res[1] = 1;
        int cur = 1;
        int high = 2;
        while(cur < num){
            for(int i = 0; i < high && cur < num; i++, cur++)
                res[i + high] = res[i] + 1;
            high *= 2;
        }
        return res;
    }
}
