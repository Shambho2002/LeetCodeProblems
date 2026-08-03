class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
		int col = board[0].length;
		
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				if(board[i][j] == word.charAt(0)){
					if(dfs(board, word, i, j, 0)){
						return true;
					}
				}
			}
		}
		
		return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int index){
		
		if(index == word.length()){
			return true;
		}
		
		if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)){
			return false;
		}
		
		char temp = board[r][c];
		board[r][c] = '#';
		
		boolean found = 
		dfs(board, word, r+1, c, index + 1) || // down
		dfs(board, word, r-1, c, index + 1) || // up
		dfs(board, word, r, c+1, index + 1) || // right
		dfs(board, word, r, c - 1, index + 1); // left
		
		board[r][c] = temp;
		
		return found;
		
	}
}