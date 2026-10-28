class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
		int n = grid[0].length;
		
		Set<Integer>[] dp = new HashSet[n];
		
		for(int j = 0; j < n; j++){
			dp[j] = new HashSet<>();
		}
		
		dp[0].add(grid[0][0]);
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 && j == 0){
					continue;
				}
				
				Set<Integer> current = new HashSet<>();
				
				if(i > 0){
					for(int x : dp[j]){
						current.add(x ^ grid[i][j]);
					}
				}
				
				if(j > 0){
					for(int x : dp[j - 1]){
						current.add(x ^ grid[i][j]);
					}
				}
				
				dp[j] = current;
			}
		}
		
		return Collections.min(dp[n - 1]);
    }
}