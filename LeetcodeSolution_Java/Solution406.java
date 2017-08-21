
public class Solution406 {
	public int[][] reconstructQueue(int[][] people) {
		//sort the list with height from tall to short
		//if height is the same, sort with number form small to big
        for(int i = 0; i < people.length - 1; i++)
        	for(int j = 0; j < people.length - i - 1; j++){
        		if(people[j][0] < people[j + 1][0]){
        			int[] temp = people[j];
        			people[j] = people[j + 1];
        			people[j + 1] = temp;
        		}else if(people[j][0] == people[j + 1][0]){
        			if(people[j][1] > people[j + 1][1]){
        				int[] temp = people[j];
            			people[j] = people[j + 1];
            			people[j + 1] = temp;
        			}
        		}
        	}
//        for(int i = 0; i < people.length - 1; i++)
//        	if(people[i][1] < i)
        return null;
    }
	
}
