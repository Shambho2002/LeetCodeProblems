class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length; // 2
		int totalNumbers = n * n; // 2 * 2 = 4
		
		int[] freq = new int[totalNumbers+1]; // size = 4+1 = 5
		
		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){
				freq[grid[i][j]]++;
			}
		}
		
		int repeated = 0;
		int missing = 0;
		
		for(int i = 1; i<=totalNumbers; i++){
			if(freq[i] == 2){
				repeated = i;
			}
			if(freq[i] == 0){
				missing = i;
			}
		}
		return new int[]{repeated, missing};
    }
}