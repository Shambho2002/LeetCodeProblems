class Solution {
    public int smallestIndex(int[] nums) {
        int smallestIndex = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
			int num = nums[i];
			int sum = 0;
			while(num > 0){
				int digits = num % 10;
				sum += digits;
				num /= 10;
			}
			if(sum == i){
				if(smallestIndex > i){
					smallestIndex = i;
				}
			}
		}
		if(smallestIndex != Integer.MAX_VALUE){
			return smallestIndex;
		}
		return -1;
    }
}