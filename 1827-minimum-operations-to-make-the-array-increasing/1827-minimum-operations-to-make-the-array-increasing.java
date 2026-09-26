class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
		for(int i = 1; i<nums.length; i++){
			if(nums[i] <= nums[i - 1]){
				int newValue = nums[i - 1] + 1;
				operations += newValue - nums[i];
				nums[i] = newValue;
			}
		}
		return operations;
    }
}