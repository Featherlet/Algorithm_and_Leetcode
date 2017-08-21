import java.util.Arrays;

public class Solution452 {
	public int findMinArrowShots(int[][] points) {
        //firstly sort all the points in order of starting point.
		if(points.length == 0)
			return 0;
		if(points.length == 1)
			return 1;
		Arrays.sort(points, (a, b) -> {return a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0];});
		//sortPoints(points);
		//intial the overlapping area
		int[] overlap = {points[0][0], points[0][1]};
		//set initial needle number
		int counter = 1;
		//traverse the rest points
		for(int i = 1; i < points.length; i++){
		    //if not overlapped with the area, set new area, counter++
			if(!isOverlapped(overlap, points[i])){
				counter++;
				overlap = points[i];
			}else{
				//if overlapped, update the overlapping area.
				int x = overlap[0] > points[i][0] ? points[i][0] : overlap[0];
				int y = overlap[1] > points[i][1] ? points[i][1] : overlap[1];
				overlap[0] = x;
				overlap[1] = y;
			}
		}
		return counter;
    }
	
	private boolean isOverlapped(int[] a, int[] b){
		if((a[0] <= b[0] && b[0] <= a[1]) || b[0] <= a[1] && a[1] <= b[1])
			return true;
		return false;
	}
	
	private void sortPoints(int[][] points){
		for(int i = 0; i < points.length - 1; i++)
			for(int j = 0; j < points.length - 1 - i; j++){
				if(points[j][0] > points[j + 1][0]){
					int[] temp = new int[2];
					temp[0] = points[j][0];
					temp[1] = points[j][1];
					points[j][0] = points[j + 1][0];
					points[j][1] = points[j + 1][1];
					points[j + 1][0] = temp[0];
					points[j + 1][1] = temp[1];
				}else if((points[j][0] == points[j + 1][0]) 
						&& (points[j][1] > points[j + 1][1])){
					int[] temp = new int[2];
					temp[0] = points[j][0];
					temp[1] = points[j][1];
					points[j][0] = points[j + 1][0];
					points[j][1] = points[j + 1][1];
					points[j + 1][0] = temp[0];
					points[j + 1][1] = temp[1];
				}
			}				
	}
}
