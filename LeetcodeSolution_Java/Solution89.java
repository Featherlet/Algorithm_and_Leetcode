import java.util.ArrayList;
import java.util.List;

public class Solution89 {
	//grey code formulation: GreyCode(n) = n xor (n >> 1)
	public List<Integer> grayCode1(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int max = (int)Math.pow(2, n) - 1;
		//int max = 1 << n;
		for(int i = 0; i <= max; i++)
			list.add(i ^ (i >> 1));
		return list;
    }
	
	//(00, 01, 11, 10)--> (000, 001, 011, 010)(110, 111, 101, 100)
	//n = 3 can be derived from n = 2: part two is symmetric to part one 
	//and only differ at the highest bit
	public List<Integer> grayCode2(int n){
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		if(n == 0){			
			return list;
		}
		list.add(1);
		if(n == 1){
			return list;
		}
		int bit = 2;
		while(bit <= n){
			int len = list.size();
			for(int i = len - 1; i >= 0; i--)
				list.add(list.get(i) + (1 << bit - 1));
			bit++;
		}
		return list;
	}
}
