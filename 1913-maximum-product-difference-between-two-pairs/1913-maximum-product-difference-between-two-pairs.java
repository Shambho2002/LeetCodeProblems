class Solution {
    public int maxProductDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		for(int i = 0; i<nums.length; i++){
			// Find two largest
			if(max < nums[i]){
				secondMax = max;
				max = nums[i];
			}
			else if(secondMax < nums[i]){
				secondMax = nums[i];
			}
			
			// Find two smallest
			if(min > nums[i]){
				secondMin = min;
				min = nums[i];
			}
			else if(secondMin > nums[i]){
				secondMin = nums[i];
			}
		}
		
		return (max * secondMax) - (min * secondMin);
    }
}