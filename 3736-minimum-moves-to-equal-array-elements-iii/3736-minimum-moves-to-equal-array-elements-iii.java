class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > max){
				max = nums[i];
			}
		}
		
		int totalMoves = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != max){
				totalMoves += (max - nums[i]);
			}
		}
		
		return totalMoves;
    }
}