class Solution {
    public int[] frequencySort(int[] nums) {
        int[] frequency = new int[201];
		
		// Count frequency
		for(int i = 0; i < nums.length; i++){
			frequency[nums[i] + 100]++;
		}
		
		int[] ans = new int[nums.length];
		int index = 0;
		
		// Frequency from smallest to largest
		for(int freq = 1; freq <= nums.length; freq++){
			
			// Value form largest to smallest
			for(int value = 100; value >= -100; value--){
				
				int frequencyIndex = value + 100;
				
				if(frequency[frequencyIndex] == freq){
					
					// Add the number freq times
					for(int k = 0; k < freq; k++){
						ans[index] = value;
						index++;
					}
				}
			}
		}
		
		return ans;
    }
}