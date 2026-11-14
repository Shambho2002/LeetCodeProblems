class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
		for(int i = 0; i < nums.size(); i++){
			int currentSum = 0;
			for(int j = i; j < nums.size(); j++){
				currentSum += nums.get(j);
				int length = j - i + 1;
				
				// Check valid subarray length
				if(length >= l && length <= r){
					
					// Check positive sum
					if(currentSum > 0){
						minSum = Math.min(minSum, currentSum);
					}
				}
				
				// No need to check long subarray
				if(length >= r){
					break;
				}
			}
		}
		
		return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}