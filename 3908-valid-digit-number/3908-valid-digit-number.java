class Solution {
    public boolean validDigit(int n, int x) {
        int firstDigit = n;
		
		while(firstDigit >= 10){
			firstDigit = firstDigit / 10;
		}
		
		if(firstDigit == x){
			return false;
		}
		
        while(n > 0){
			int digit = n % 10;
			if(digit == x){
				return true;
			}
			n /= 10;
		}
		return false;
    }
}