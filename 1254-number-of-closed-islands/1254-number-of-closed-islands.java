class Solution {
    private boolean dfs(int[][]grid, int row, int col){
		int rows = grid.length;
		int cols = grid[0].length;
		
		// Out of bounds means the island is not closed
		if(row < 0 || row >= rows || col < 0 || col >= cols){
			return false;
		}
		
		// Water does not affect whether the island is closed
		if(grid[row][col] == 1){
			return true;
		}
		
		// Mark the land as visited
		grid[row][col] = 1;
		
		// Explore all four directions
		boolean up = dfs(grid, row - 1, col);
		boolean down = dfs(grid, row + 1, col);
		boolean left = dfs(grid, row, col - 1);
		boolean right = dfs(grid, row, col + 1);
		
		return up && down && left && right;
	}
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(grid[i][j] == 0){
					if(dfs(grid, i, j)){
						count++;
					}
				}
			}
		}
		
		return count;
    }
}