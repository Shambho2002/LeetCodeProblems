class Solution {
    public int smallestNumber(int n) {
        int x = 1; // 7
		
		while(x < n){
			x = x * 2 + 1; // 3 * 2 + 1 = 6 + 1 = 7
		}
		
		return x; // 7
    }
}