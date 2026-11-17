class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
		
		// Step 1: Precompute minimum cost for every substring
		int[][] cost = new int[n][n];
		
		for(int start = 0; start < n; start++){
			for(int end = start + 1; end < n; end++){
				int len = end - start + 1;
				int minChanges = Integer.MAX_VALUE;
				
				// Try every valid divisor
				for(int d = 1; d < len; d++){
					if(len % d != 0){
						continue;
					}
					
					int changes = 0;
					
					// Check all d groups
					for(int offset = 0; offset < d; offset++){
						int left = start + offset;
						int right = end - d + 1 + offset;
						
						// Compare opposite characters
						// Within the same group
						while(left < right){
							if(s.charAt(left) != s.charAt(right)){
								changes = changes + 1;
							}
							
							left = left + d;
							right = right - d;
						}
					}
					
					// Keep minimum changes
					minChanges = Math.min(minChanges, changes);
				}
				
				cost[start][end] = minChanges;
			}
		}
		
		// Step 2: Initialize DP
		int[][] dp = new int[n + 1][k + 1];
		
		// Fill dp with INFINITY
		for(int i = 0; i <= n; i++){
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		dp[0][0] = 0;
		
		// Step 3: Apply Dynamic Programming
		for(int parts = 1; parts <= k; parts++){
			
			// At least 2 characters per substring
			for(int i = 2 * parts; i <= n; i++){
				
				// Decide where the last substring starts
				for(int j = 2 * (parts - 1); j <= i - 2; j++){
					if(dp[j][parts - 1] != Integer.MAX_VALUE){
						int currentCost = dp[j][parts - 1] + cost[j][i - 1];
						dp[i][parts] = Math.min(dp[i][parts], currentCost);
					}
				}
			}
		}
		
		// Step 4: Return answer
		return dp[n][k];
    }
}