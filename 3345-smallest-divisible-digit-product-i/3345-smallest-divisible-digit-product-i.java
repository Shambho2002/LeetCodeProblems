class Solution {
    public int productOfDigits(int n){
		int product = 1;
		
		while(n != 0){
			int digit = n % 10;
			product *= digit;
			n /= 10;
		}
		
		return product;
	}
    public int smallestNumber(int n, int t) {
        while(true){
			int product = productOfDigits(n);
			
			if(product % t == 0){
				return n;
			}
			
			n = n + 1;
		}
    }
}