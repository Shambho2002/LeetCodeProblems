class Solution {
    public int[] transformArray(int[] nums) {
        int[] ans = new int[nums.length];
		
		int zeroCount = 0;
		
		// Count even numbers
		for(int num: nums){
			if(num%2 == 0){
				zeroCount++;
			}
		}
		
		// Put zeros first
		for(int i = 0; i<zeroCount; i++){
			ans[i] = 0;
		}
		
		// Put ones after zeros
		for(int i = zeroCount; i<nums.length; i++){
			ans[i] = 1;
		}
		
		return ans;
    }
}