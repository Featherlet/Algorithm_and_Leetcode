
public class Solution48 {
	public void rotate(int[][] matrix) {
		//rotate 180 clockwise
		/*int n = matrix.length;
		for(int i = 0; i < n / 2; i++)
			for(int j = 0; j < n; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = temp;
			}
		
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}*/
		int n = matrix.length;
		int[][] newm = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++){
				newm[i][j] = matrix[n - 1 - j][i];
			}
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++){
				matrix[i][j] = newm[i][j];
			}
    }

}
