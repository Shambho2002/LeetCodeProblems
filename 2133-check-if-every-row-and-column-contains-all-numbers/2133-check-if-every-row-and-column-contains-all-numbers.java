class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
		
		// Check every row
        for(int i = 0; i<n; i++){
			HashSet<Integer> row = new HashSet<Integer>();
			for(int j = 0; j<n; j++){
				row.add(matrix[i][j]);
			}
			if(row.size() != n){
				return false;
			}
		}
		
		// Check every column
		for(int j = 0; j<n; j++){
			HashSet<Integer> column = new HashSet<Integer>();
			for(int i = 0; i<n; i++){
				column.add(matrix[i][j]);
			}
			if(column.size() != n){
				return false;
			}
		}
		return true;
    }
}