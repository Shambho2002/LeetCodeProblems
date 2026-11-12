class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1; // 1
		int dec = 1; // 1
		
		int maxLength = 1; // 2
		
		for(int i = 1; i < nums.length; i++){ // i = 4 = 4 < 4 = false
			if(nums[i] > nums[i - 1]){ // 3 > 3 = false
				inc = inc + 1; // +1
				dec = 1; // 1
			}
			else if(nums[i] < nums[i - 1]){ // 3 < 3 = false
				dec = dec + 1; // +1
				inc = 1; // 1
			}
			else{
				inc = 1; // 1
				dec = 1; // 1
			}
			
			maxLength = Math.max(maxLength, Math.max(inc, dec)); // Math.max(2, Math.max(1, 1)) = Math.max(2, 1) = 2
		}
		
		return maxLength;
    }
}