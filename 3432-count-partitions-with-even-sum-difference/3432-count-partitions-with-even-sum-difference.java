class Solution {
    public int countPartitions(int[] nums) {
        int count = 0;
		int outerSum = 0;
		for(int i = 0; i<nums.length-1; i++){
			outerSum += nums[i];
			int innerSum = 0;
			for(int j = i+1; j<nums.length; j++){
				innerSum += nums[j];
			}
			if((outerSum - innerSum)%2 == 0){
				count++;
			}
		}
		
		return count;
    }
}