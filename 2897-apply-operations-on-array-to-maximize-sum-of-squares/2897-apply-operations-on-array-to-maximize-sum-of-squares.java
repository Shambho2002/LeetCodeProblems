class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1000000007;
		int[] bitCount = new int[30];
		
		for(int num: nums){
			for(int bit = 0; bit < 30; bit++){
				if((num & (1 << bit)) != 0){
					bitCount[bit]++;
				}
			}
		}
		
		long sum = 0;
		
		for(int i = 0; i < k; i++){
			int num = 0;
			
			for(int bit = 0; bit < 30; bit++){
				if(bitCount[bit] > 0){
					num = num | (1 << bit);
					bitCount[bit]--;
				}
			}
			
			sum = (sum + (long)num * num) % MOD;
		}
		
		return (int)sum;
    }
}