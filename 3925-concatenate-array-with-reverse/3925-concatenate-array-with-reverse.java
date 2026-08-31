class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[nums.length * 2]; // 3 * 2 == 6
		
		for(int i = 0; i<nums.length; i++){
			ans[i] = nums[i]; // ans[2] = 3
			ans[i + nums.length] = nums[nums.length - i - 1]; // ans[5] = nums[0]
		}
		
		return ans; // 1 2 3 3 2 1
    }
}