class Solution {
    public long dfs(int[][] grid, int row, int col){
		int m = grid.length;
		int n = grid[0].length;
		
		// Boundary and water checks
		if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0){
			return 0;
		}
		
		// Store current value and mark as visited
		long sum = grid[row][col];
		grid[row][col] = 0;
		
		// Explore four directions
		sum += dfs(grid, row - 1, col);
		sum += dfs(grid, row + 1, col);
		sum += dfs(grid, row, col - 1);
		sum += dfs(grid, row, col + 1);
		
		return sum;
	}
    public int countIslands(int[][] grid, int k) {
        int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		
		for(int i = 0; i < m; i++){ // row
			for(int j = 0; j < n; j++){ // column
				if(grid[i][j] > 0){
					long islandSum = dfs(grid, i, j);
					
					if(islandSum % k == 0){
						count++;
					}
				}
			}
		}
		
		return count;
    }
}