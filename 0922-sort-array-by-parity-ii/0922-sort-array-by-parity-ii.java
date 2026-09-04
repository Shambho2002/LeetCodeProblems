class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
		
		int evenIndex = 0;
		int oddIndex = 1;
		
		for(int x: nums){
			
			if(x%2 == 0){
				ans[evenIndex] = x;
				evenIndex += 2;
			}
			else{
				ans[oddIndex] = x;
				oddIndex += 2;
			}
		}
		
		return ans;
    }
}