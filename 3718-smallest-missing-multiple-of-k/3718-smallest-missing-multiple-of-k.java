class Solution {
    public int missingMultiple(int[] nums, int k) {
        int multiple = k; // 10
		
		while(true){ // true
			boolean found = false; // false
			
			for(int i = 0; i<nums.length; i++){ // nums[4]
				if(nums[i] == multiple){ // 6 == 10 false
					found = true; // false
					break;
				}
			}
			
			if(!found){ // true
				return multiple; // return 10
			}
			
			multiple = multiple + k; // 8 + 2 == 10
		}
    }
}