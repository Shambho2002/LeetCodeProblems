class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
		
		int size = 0; // 4
		for(int i = 0; i<nums.length; i++){ // i = 5 == false
			int position = index[i]; // 1
			
			for(int j = size; j > index[i]; j--){ // false j = 1
				ans[j] = ans[j - 1]; // ans[4] = ans[2 - 1]
			}
			
			ans[position] = nums[i]; // ans[1] = nums[4];
			size++; // 5
		}
		
		return ans;
    }
}