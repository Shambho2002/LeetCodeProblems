class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
		boolean[] seen = new boolean[51];
		
		for(int i = 0; i<nums.length; i++){
			int num = nums[i];
			if(seen[num]){
				ans = ans ^ num;
			}
			else{
				seen[num] = true;
			}
		}
		
		return ans;
    }
}