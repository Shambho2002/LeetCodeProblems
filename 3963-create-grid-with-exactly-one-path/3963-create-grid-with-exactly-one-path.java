class Solution {
    public String[] createGrid(int m, int n) {
        String[][] grid = new String[m][n];
		
        for(int i = 0; i < m; i++){ // rows
			for(int j = 0; j < n; j++){ // cols
				grid[i][j] = "#";
			}
		}
		
		for(int j = 0; j < n; j++){
			grid[0][j] = ".";
		}
		
		for(int i = 1; i < m; i++){
			grid[i][n - 1] = ".";
		}
		
		String[] result = new String[m];
		
		for(int i = 0; i < m; i++){
			StringBuilder row = new StringBuilder();
			
			for(int j = 0; j < n; j++){
				row.append(grid[i][j]);
			}
			
			result[i] = row.toString();
		}
		
		return result;
    }
}