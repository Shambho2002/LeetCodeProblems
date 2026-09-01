class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] frequency = new int[101];
		
		for(int i = 0; i<nums.length; i++){
			frequency[nums[i]]++;
		}
		
		int max = 0;
		for(int i = 0; i<frequency.length; i++){
			if(frequency[i] > max){
				max = frequency[i];
			}
		}
		
		int count = 0;
		for(int i = 0; i<frequency.length; i++){
			if(frequency[i] == max){
				count += frequency[i];
			}
		}
		
		return count;
    }
}