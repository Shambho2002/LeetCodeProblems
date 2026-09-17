class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i<nums.length-1; i++){
			if(nums[i] == nums[i+1]){
				nums[i] = (nums[i]*2);
				nums[i+1] = 0;
			}
			else{
				continue;
			}
		}
		
		int i = 0;
		for(int j = 0; j<nums.length; j++){
			if(nums[j] != 0){
				nums[i] = nums[j];
				i++;
			}
		}
		
		while(i<nums.length){
			nums[i] = 0;
			i++;
		}
		
		return nums;
    }
}