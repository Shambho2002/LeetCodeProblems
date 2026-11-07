class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
		int m = tasks.length;
		
		// Free servers: [weight, index]
		PriorityQueue<int[]> freeServers = new PriorityQueue<>(
			(a, b) -> {
				if(a[0] != b[0])
					return a[0] - b[0];
				return a[1] - b[1];
			}
		);
		
		// Busy servers: [freeTime, weight, index]
		PriorityQueue<int[]> busyServers = new PriorityQueue<>(
			(a, b) -> {
				if(a[0] != b[0])
					return Integer.compare(a[0], b[0]);
				return Integer.compare(a[1], b[1]);
			}
		);
		
		// Initially, all servers are free
		for(int i = 0; i < n; i++){
			freeServers.offer(new int[]{servers[i], i});
		}
		
		int[] ans = new int[m];
		long currentTime = 0;
		
		for(int i = 0; i < m; i++){
			currentTime = Math.max(currentTime, i);
			
			// Release completed servers
			while(!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime){
				int[] server = busyServers.poll();
				
				freeServers.offer(
					new int[]{server[1], server[2]}
				);
			}
			
			// If no server is free, wait
			if(freeServers.isEmpty()){
				currentTime = busyServers.peek()[0];
				
				// Release all servers free at this time
				while(!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime){
					int[] server = busyServers.poll();
					
					freeServers.offer(
						new int[]{server[1], server[2]}
					);
				}
			}
			
			// Select the best available server
			int[] server = freeServers.poll();
			
			int weight = server[0];
			int index = server[1];
			
			ans[i] = index;
			
			// Assign task and calculate completion time
			long freeTime = currentTime + tasks[i];
			
			busyServers.offer(
				new int[]{(int) freeTime, weight, index}
			);
		}
		
		return ans;
    }
}