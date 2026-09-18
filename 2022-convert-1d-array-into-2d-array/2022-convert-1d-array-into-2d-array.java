class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n){
			return new int[][]{};
		}
		
        int[][] ans = new int[m][n];
		
		int index = 0;
		for(int i = 0; i<ans.length; i++){ // rows
			for(int j = 0; j<ans[i].length; j++){ // columns
				ans[i][j] = original[index];
				index++;
			}
		}
		return ans;
    }
}