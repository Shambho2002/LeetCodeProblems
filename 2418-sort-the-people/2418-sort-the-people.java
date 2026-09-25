class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        for(int i = 0; i<heights.length; i++){
			int maxIndex = i;
			// Find the tallest person
			for(int j = i+1; j<names.length; j++){
				if(heights[j] > heights[maxIndex]){
					maxIndex = j;
				}
			}
			
			// Swap heights
			int tempHeight = heights[i];
			heights[i] = heights[maxIndex];
			heights[maxIndex] = tempHeight;
			
			// Swap names at the same time
			String tempName = names[i];
			names[i] = names[maxIndex];
			names[maxIndex] = tempName;
		}
		return names;
    }
}