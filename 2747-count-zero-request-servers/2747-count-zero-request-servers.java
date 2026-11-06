class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // Step 1: Sort logs by time 
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
		
		int m = queries.length;
		
		// Step 2: Store query and original index
		int[][] sortedQueries = new int[m][2];
		
		for(int i = 0; i < m; i++){
			sortedQueries[i][0] = queries[i];
			sortedQueries[i][1] = i;
		}
		
		// Step 3: Sort queries by time
		Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
		
		int[] freq = new int[n + 1];
		int[] ans = new int[m];
		
		int left = 0;
		int right = 0;
		int activeServers = 0;
		
		// Step 4: Process each query
		for(int[] q: sortedQueries){
			int time = q[0];
			int index = q[1];
			
			// Add logs with time <= query
			while(right < logs.length && logs[right][1] <= time){
				int serverId = logs[right][0];
				
				if(freq[serverId] == 0){
					activeServers++;
				}
				
				freq[serverId]++;
				right++;
			}
			
			// Remove logs before window start
			while(left < right && logs[left][1] < time - x){
				int serverId = logs[left][0];
			
				freq[serverId]--;
			
				if(freq[serverId] == 0){
					activeServers--;
				}
			
				left++;
			}
		
			// Step 5: Count inactive servers
			ans[index] = n - activeServers;
		}
		
		return ans;
    }
}