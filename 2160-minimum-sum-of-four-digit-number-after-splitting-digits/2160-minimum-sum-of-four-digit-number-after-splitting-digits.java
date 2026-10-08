class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
		
		// Extract all 4 digits
		digits[0] = num % 10;
		num = num / 10;
		
		digits[1] = num % 10;
		num = num / 10;
		
		digits[2] = num % 10;
		num = num / 10;
		
		digits[3] = num % 10;
		num = num / 10;
		
		Arrays.sort(digits);
		
		int new1 = digits[0] * 10 + digits[2];
		int new2 = digits[1] * 10 + digits[3];
		
		return new1 + new2;
    }
}