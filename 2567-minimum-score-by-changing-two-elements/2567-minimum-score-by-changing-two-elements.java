class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums); // 1, 4, 5, 7, 8
		
		int n = nums.length; // 5
		
		int case1 = Math.abs(nums[n - 1] - nums[2]); // Math.abs(nums[5 - 1] - nums[2]) = nums[4] - nums[2] = 8 - 5 = 3
		
		int case2 = Math.abs(nums[n - 2] - nums[1]); // Math.abs(nums[5 - 2] - nums[1]) = nums[3] - nums[1] = 7 - 4 = 3
		
		int case3 = Math.abs(nums[n - 3] - nums[0]); // Math.abs(nums[5 - 3] - nums[0]) = nums[2] - nums[0] = 5 - 1 = 4
		
		return Math.min(case1, Math.min(case2, case3)); // Math.min(3, Math.min(3, 4)) = Math.min(3, 3) = 3
    }
}