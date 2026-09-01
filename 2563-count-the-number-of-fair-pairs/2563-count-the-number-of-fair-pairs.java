import java.util.Arrays;
class Solution {
    public long countPairs(int[] nums, long limit){
		
		int left = 0;
		int right = nums.length - 1;
		
		long count = 0;
		
		while(left < right){
			long sum = (long) nums[left] + nums[right];
			
			if(sum <= limit){
				count += right - left;
				left++;
			}
			else{
				right--;
			}
		}
		
		return count;
		
	}
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
		
		return countPairs(nums, upper) - countPairs(nums, (long)lower - 1);
    }
}