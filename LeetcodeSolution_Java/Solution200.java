
public class Solution200 {
	public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++){
        		if(sink(i, j, grid) == 1)
        			count++;
        	}
        return count;
    }
	
	public int sink(int i, int j, char[][] grid){
		if(grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
        int n = grid[0].length;
		if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
			return 0;
		grid[i][j] = '0';
		sink(i - 1, j, grid);
		sink(i + 1, j, grid);
		sink(i, j - 1, grid);
		sink(i, j + 1, grid);
		return 1;
	}

}
