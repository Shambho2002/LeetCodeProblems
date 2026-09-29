class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
		int n = grid[0].length;
		
		int totalLength = m + n  - 1;
		
		// Valid parentheses string must have even length
		if(totalLength % 2 != 0){
			return false;
		}
		
		// dp[i][j][balance]
		boolean[][][] dp = new boolean[m][n][totalLength + 1];
		
		// First character must be '('
		if(grid[0][0] == ')'){
			return false;
		}
		
		// Starting balance = 1
		dp[0][0][1] = true;
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				for(int balance = 0; balance <= totalLength; balance++){
					if(!dp[i][j][balance]){
						continue;
					}
					
					// Move DOWN
					if(i + 1 < m){
						int newBalance;
						if(grid[i + 1][j] == '('){
							newBalance = balance + 1;
						}
						else{
							newBalance = balance - 1;
						}
						
						// Balance should never become negative
						if(newBalance >= 0){
							dp[i+1][j][newBalance] = true;
						}
					}
					
					// Move RIGHT
					if(j + 1 < n){
						int newBalance;
						if(grid[i][j + 1] == '('){
							newBalance = balance + 1;
						}
						else{
							newBalance = balance - 1;
						}
						
						// Balance should never become negative
						if(newBalance >= 0){
							dp[i][j+1][newBalance] = true;
						}
					}
				}
			}
		}
		
		// At the end, balance must be 0
		return dp[m - 1][n - 1][0];
    }
}