class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int[] freq = new int[101];
		
		for(int i = 0; i<nums.length; i++){
			freq[nums[i]]++;
		}
		
		int middle = nums.length / 2;
		
		if(freq[nums[middle]] == 1){
			return true;
		}
		return false;
    }
}