class Solution {
    public boolean squareIsWhite(String coordinates) {
        // Convert to character array
		char[] coordinate = coordinates.toCharArray();
		
        int column = coordinate[0] - 'a' + 1;
		int row = coordinate[1] - '0';
		
		if((column + row) % 2 == 0){
			return false;
		}
		else{
			return true;
		}
    }
}