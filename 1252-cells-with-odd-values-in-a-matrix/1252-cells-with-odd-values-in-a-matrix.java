class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rowCount = new int[m];
		int[] colCount = new int[n];
		
		// Count increments for each row and column
		for(int i = 0; i < indices.length; i++){
			int r = indices[i][0];
			int c = indices[i][1];
			
			rowCount[r]++;
			colCount[c]++;
		}
		
		int oddRows = 0;
		int oddCols = 0;
		
		// Count rows with odd increments
		for(int i = 0; i < m; i++){
			if(rowCount[i] % 2 != 0){
				oddRows = oddRows + 1;
			}
		}
		
		// Count columns with odd increments
		for(int i = 0; i < n; i++){
			if(colCount[i] % 2 != 0){
				oddCols = oddCols + 1;
			}
		}
		
		int evenRows = m - oddRows;
		int evenCols = n - oddCols;
		
		int oddCells = (oddRows * evenCols) + (evenRows * oddCols);
		
		return oddCells;
    }
}