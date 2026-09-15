class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0;
        for(int i = nums.length - 1; i>=0; i--){
			if(i%2 == 0){
				sum += nums[i];
			}
			else{
				sum -= nums[i];
			}
		}
		return sum;
    }
}