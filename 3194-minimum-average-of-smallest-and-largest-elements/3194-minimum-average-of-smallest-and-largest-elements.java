class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length - 1;
		
		double minAverage = Integer.MAX_VALUE;
		while(left < right){
			double ave = (nums[left] + nums[right]) / 2.0;
			if(minAverage > ave){
				minAverage = ave;
			}
			left++;
			right--;
		}
		return minAverage;
    }
}