class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];
		
        for(int i = 0; i<matrix.length; i++){ // row
			for(int j = 0; j<matrix[i].length; j++){ // column
				if(matrix[i][j] == 1){
					ans[i] = (ans[i] + matrix[i][j]);
				}
			}
		}
		return ans;
    }
}