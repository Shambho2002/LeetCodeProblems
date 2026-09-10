class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
		int n = nums.length;
		
		for(int mask = 0; mask < (1 << n); mask++){
			int xor = 0;
			for(int i = 0; i<n; i++){
				if((mask & (1 << i)) != 0){
					xor = xor ^ nums[i];
				}
			}
			sum = sum + xor;
		}
		
		return sum;
    }
}