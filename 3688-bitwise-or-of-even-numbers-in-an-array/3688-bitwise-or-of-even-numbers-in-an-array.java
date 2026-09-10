class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int OR = 0;
		for(int i = 0; i<nums.length; i++){
			if(nums[i]%2 == 0){
				OR = OR | nums[i];
			}
		}
		return OR;
    }
}