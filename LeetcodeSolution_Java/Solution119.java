import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution119 {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if(rowIndex == 0)
            list.add(1);
        else if(rowIndex == 1){
            list.add(1);
            list.add(1);
        }else{
            int[] array = new int[rowIndex + 1];
            int level = 2;
            array[0] = 1;
            array[1] = 2;
            array[2] = 1;
            while(level < rowIndex){
                level++;
                array[level] = 1;
                for(int i = level - 1; i > 0; i--)
                    array[i] = array[i] + array[i - 1];
                array[0] = 1;
            }
            for(int i = 0; i < array.length; i++)
                list.add(array[i]);
        }
        return list;
    }
}
