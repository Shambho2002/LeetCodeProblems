class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
		int digitSum = 0;
		
		for(int i = 0; i<nums.length; i++){
			
			// element sum
			elementSum += nums[i];
			
			// digit sum
			
			int n = nums[i];
			while(n > 0){
				digitSum += n % 10;
				n = n / 10;
			}
		}
		
		return Math.abs(elementSum - digitSum);
    }
}