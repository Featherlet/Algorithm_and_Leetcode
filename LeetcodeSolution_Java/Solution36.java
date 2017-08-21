import java.util.HashSet;
import java.util.Set;

public class Solution36 {
	public boolean isValidSudoku(char[][] board) {
        //judge each row
		for(int i = 0; i < board.length; i++){
			Set<Character> record = new HashSet<Character>();
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] >= '0' && board[i][j] <= '9'){
					if(record.contains(board[i][j]))
						return false;
					record.add(board[i][j]);
				}
			}
		}
		
		//judge each column
		for(int j = 0; j < board[0].length; j++){
			Set<Character> record = new HashSet<Character>();
			for(int i = 0; i < board.length; i++){
				if(board[i][j] >= '0' && board[i][j] <= '9'){
					if(record.contains(board[i][j]))
						return false;
					record.add(board[i][j]);
				}
			}
		}
		
		//judge each big cell
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++){
				//each big cell
				Set<Character> record = new HashSet<Character>();
				for(int n = 0; n < 3; n++)
					for(int m = 0; m < 3; m++){
						if(board[i * 3 + n][j * 3 + m] >= '0' && board[i * 3 + n][j * 3 + m] <= '9'){
							if(record.contains(board[i * 3 + n][j * 3 + m]))
								return false;
							record.add(board[i * 3 + n][j * 3 + m]);
						}
					}
			}
		return true;
    }
}
