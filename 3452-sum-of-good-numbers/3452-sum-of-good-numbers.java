class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
		for(int i = 0; i<nums.length; i++){
			boolean good = true;
			
			if(i - k >= 0 && nums[i] <= nums[i - k]){
				good = false;
			}
			
			if(i + k < nums.length && nums[i] <= nums[i + k]){
				good = false;
			}
			
			if(good){
				sum += nums[i];
			}
		}
		
		return sum;
    }
}