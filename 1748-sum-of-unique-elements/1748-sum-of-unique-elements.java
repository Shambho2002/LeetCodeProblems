class Solution {
    public int sumOfUnique(int[] nums) {
        int[] frequency = new int[101];
		int sum = 0;
		
		for(int i = 0; i<nums.length; i++){
			frequency[nums[i]]++;
		}
		
		for(int i = 1; i<frequency.length; i++){
			if(frequency[i] == 1){
				sum += i;
			}
		}
		
		return sum;
    }
}