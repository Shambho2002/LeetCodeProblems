class Solution {
    public int minMoves(int[] nums) {
        // Find the minimum element in nums
        int minimum = Integer.MAX_VALUE; // 1
		for(int i = 0; i < nums.length; i++){
			if(nums[i] < minimum){
				minimum = nums[i];
			}
		}
		
		int moves = 0; // 3
		
		for(int element: nums){ // 1
			moves = moves + (element - minimum); // 0 + (3 - 1) = 1 + 2 = 3
		}
		
		return moves; // 3
    }
}