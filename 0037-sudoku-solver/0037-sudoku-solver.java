class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
		
		// Traverse whole board
		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				
				// Find empty cells
				if(board[row][col] == '.'){
					
					// try numbers 1 to 9
					for(char ch = '1'; ch <= '9'; ch++){
						
						if(isSafe(board, row, col, ch)){
							board[row][col] = ch;
							
							if(solve(board)){
								return true;
							}
							board[row][col] = '.';
						}
						
					}
					
					return false;
					
				}
				
			}
		}
		
		return true;
		
	}
	public boolean isSafe(char[][] board, int row, int col, char ch){
		
		// Row check
		for(int i = 0; i<9; i++){
			if(board[row][i] == ch){
				return false;
			}
		}
		
		// Column check
		for(int i = 0; i<9; i++){
			if(board[i][col] == ch){
				return false;
			}
		}
		
		// 3x3 box check
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		
		for(int i = startRow; i<startRow + 3; i++){
			for(int j = startCol; j<startCol + 3; j++){
				if(board[i][j] == ch){
					return false;
				}
			}
		}
		
		return true;
		
	}
	public void printBoard(char[][] board) {
        
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
    }
}