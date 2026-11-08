class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length; // Number of rows
		int n = grid[0].length; // Number of columns
		
		int[] rowCount = new int[m];
		int[] colCount = new int[n];
		
		// First traversal: Count servers in each row and column
		for(int i = 0; i < m; i++){ // row
			for(int j = 0; j < n; j++){ // column
				if(grid[i][j] == 1){
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}
		
		// Second traversal: Count communicating servers
		int ans = 0;
		
		for(int i = 0; i < m; i++){ // row
			for(int j = 0; j < n; j++){ // column
				if(grid[i][j] == 1){
					if(rowCount[i] > 1 || colCount[j] > 1){
						ans++;
					}
				}
			}
		}
		
		return ans;
    }
}