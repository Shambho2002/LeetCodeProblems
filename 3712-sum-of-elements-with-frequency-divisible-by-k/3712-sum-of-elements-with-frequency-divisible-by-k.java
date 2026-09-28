class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] frequency = new int[101];
		
		for(int i = 0; i<nums.length; i++){
			frequency[nums[i]]++;
		}
		
		int sum = 0;
		
		// Check which frequency are divisible by k
		for(int i = 1; i<frequency.length; i++){
			if(frequency[i] % k == 0){
				sum += frequency[i] * i;
			}
		}
		
		return sum;
    }
}