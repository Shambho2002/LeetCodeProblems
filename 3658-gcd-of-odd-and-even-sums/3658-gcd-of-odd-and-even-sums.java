class Solution {
    public int GCD(int sumOdd, int sumEven){
		int a = sumOdd;
		int b = sumEven;
		
		while(b != 0){
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		
		return a;
	}
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
		int sumEven = 0;
		
		for(int i = 1; i <= n; i++){
			
			int odd = 2 * i - 1;
			int even = 2 * i;
			
			sumOdd += odd;
			sumEven += even;
			
		}
		
		return GCD(sumOdd, sumEven);
    }
}