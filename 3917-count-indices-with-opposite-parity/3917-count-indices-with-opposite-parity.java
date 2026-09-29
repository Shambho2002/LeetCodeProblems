class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[] ans = new int[nums.length];
		
		for(int i = 0; i<nums.length; i++){
			int count = 0;
			for(int j = i+1; j<nums.length; j++){
				if(nums[i] % 2 != nums[j] % 2){
					count++;
				}
			}
			
			ans[i] = count;
		}
		
		return ans;
    }
}