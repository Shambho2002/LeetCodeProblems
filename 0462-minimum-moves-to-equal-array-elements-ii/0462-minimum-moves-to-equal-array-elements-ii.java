class Solution {
    public int minMoves2(int[] nums) {
        // Sort the given array in ascending order
        Arrays.sort(nums);
		
		// length of given array
		int n = nums.length; // 3
		
		// Find median
		int median = nums[n / 2]; // nums[3 / 2] = nums[1] = 2
		
		// Initialize moves variable
		int moves = 0; // 1
		for(int element: nums){ // 3
			moves += Math.abs(element - median); // 1 + (3 - 2) = 1 + 1 = 2
		}
		
		return moves; // 2
    }
}