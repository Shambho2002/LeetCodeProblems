class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
		
		PriorityQueue<int[]> busy = new PriorityQueue<>(
			(a, b) -> Integer.compare(a[0], b[0])
		);
		
		int[] count = new int[k];
		
		// Initially, all servers are available
		for(int i = 0; i < k; i++){
			available.add(i);
		}
		
		// Process each request
		for(int i = 0; i < arrival.length; i++){
			int currentTime = arrival[i];
			
			// Release servers that have completed their requests
			while(!busy.isEmpty() && busy.peek()[0] <= currentTime){
				int[] completed = busy.poll();
				available.add(completed[1]);
			}
			
			// If all the servers are busy, drop the request
			if(available.isEmpty()){
				continue;
			}
		
			int preferred = i % k;
		
			Integer server = available.ceiling(preferred);
		
			// Wrap around if necessary
			if(server == null){
				server = available.first();
			}
		
			// Assign request to server
			available.remove(server);
		
			count[server]++;
		
			// Calculate completion time
			int finishTime = arrival[i] + load[i];
		
			// Mark server as busy
			busy.offer(new int[]{finishTime, server});
			
		}
		
		// Find maximum number of requests handled
		int maxRequests = 0;
		
		for(int requests : count){
			maxRequests = Math.max(maxRequests, requests);
		}
		
		// Collect busiest servers
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < k; i++){
			if(count[i] == maxRequests){
				result.add(i);
			}
		}
		
		return result;
    }
}