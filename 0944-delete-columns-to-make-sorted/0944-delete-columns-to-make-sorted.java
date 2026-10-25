class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
		
		int rows = strs.length;
		int cols = strs[0].length();
		
		for(int col = 0; col < cols; col++){
			for(int row = 1; row < rows; row++){
				if(strs[row].charAt(col) < strs[row - 1].charAt(col)){
					count++;
					break;
				}
			}
		}
		
		return count;
    }
}