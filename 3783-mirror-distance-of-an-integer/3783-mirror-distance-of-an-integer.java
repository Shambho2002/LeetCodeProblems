class Solution {
    public int mirrorDistance(int n) {
        int original = n;
		int reverse = 0;
		
		while(original != 0){
			int digit = original % 10;
			reverse = reverse * 10 + digit;
			original /= 10;
		}
		
		return Math.abs(n - reverse);
    }
}