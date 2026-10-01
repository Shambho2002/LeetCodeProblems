class Solution {
    public boolean checkGoodInteger(int n) {
        int squareSum = 0;
		int digitSum = 0;
		
		while(n != 0){
			int digit = n % 10;
			digitSum += digit;
			squareSum += (digit * digit);
			n = n / 10;
		}
		
		return squareSum - digitSum >= 50;
    }
}