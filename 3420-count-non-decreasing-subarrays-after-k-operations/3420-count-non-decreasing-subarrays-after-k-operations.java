class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
		
		long ans = 0;
		long cost = 0;
		
		int right = n - 1;
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int left = n - 1; left >= 0; left--){
			
			// Maintain a decreasing monotonic deque
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[left]){
				int index = dq.pollLast();
				int r = dq.isEmpty() ? right + 1 : dq.peekLast();
				
				// Calculate additional operations
				cost += (long) (r - index) * (nums[left] - nums[index]);
			}
			
			dq.offerLast(left);
		
			// Shrink window if operations exceed k
			while(cost > k){
				cost -= nums[dq.peekFirst()] - nums[right];
			
				if(dq.peekFirst() == right){
					dq.pollFirst();
				}
			
				right--;
			}
		
			// Count valid subarrays
			ans += right - left + 1;
		}
		
		return ans;
    }
}