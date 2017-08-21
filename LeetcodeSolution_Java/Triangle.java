import java.util.List;

public class Triangle {
	
	void getTriangle(int[][] num, int row){
		for(int i = 0; i < row; i++){
			num[i][0] = 1;
			num[i][i] = 1;
		}
		for(int i = 2; i < row; i++)
			for(int j = 1; j < i; j++)
				num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
	}
	
	void printTriangle(int[][] num, int row){
		for(int i = 0; i < row; i++){
			for(int k = 0; k < row - i; k++)
				System.out.print("  ");
			for(int j = 0; j <= i; j++)
				System.out.print(num[i][j] + "   ");
			System.out.print("\n");
		}
	}
	
	void printTriangle2(List<List<Integer>> all){
		for(List<Integer> row: all){
			for(int num : row)
				System.out.print(num + " ");
			System.out.print("\n");
		}
	}
}
