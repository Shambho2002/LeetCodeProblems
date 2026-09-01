class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
		
		int totalSum = 0;
		for(int i = 0; i<nums.length; i++){
			totalSum += nums[i];
		}
		
		int leftSum = 0;
		for(int i = 0; i<nums.length; i++){
			
			int rightSum = totalSum - leftSum - nums[i];
			
			int difference = Math.abs(leftSum - rightSum);
			
			ans[i] = difference;
			
			leftSum = leftSum + nums[i];
		}
		
		return ans;
    }
}