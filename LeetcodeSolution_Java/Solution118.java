import java.util.ArrayList;
import java.util.List;

public class Solution118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> all = new ArrayList();
		if(numRows == 1){
        	ArrayList<Integer> row = new ArrayList<Integer>();
        	row.add(1);
        	all.add(row);
        }else if(numRows >= 2){
        	ArrayList<Integer> row1 = new ArrayList<Integer>();
        	ArrayList<Integer> row2 = new ArrayList<Integer>();
        	row1.add(1);
        	row2.add(1);
        	row2.add(1);
        	all.add(row1);
        	all.add(row2);
        	for(int i = 2; i < numRows; i++){
        		ArrayList<Integer> row = new ArrayList<Integer>();
        		row.add(1);
        		for(int j = 1; j < i; j++){
        			int a = all.get(i - 1).get(j - 1).intValue() + all.get(i - 1).get(j).intValue();
        			row.add(a);
        		}
        		row.add(1);
        		all.add(row);
        	}
        }
        return all;
		
	}
}
