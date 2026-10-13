class Solution {
    public List<String> cellsInRange(String s) {
        char startCol = s.charAt(0);
		int startRow = s.charAt(1) - '0';
		
		char endCol = s.charAt(3);
		int endRow = s.charAt(4) - '0';
		
		List<String> result = new ArrayList<String>();
		
		for(char col = startCol; col <= endCol; col++){ // column
			for(int row = startRow; row <= endRow; row++){ // row
				result.add(""+col+row);
			}
		}
		return result;
    }
}