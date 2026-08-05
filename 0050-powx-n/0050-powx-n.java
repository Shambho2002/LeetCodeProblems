class Solution {
    public double myPow(double x, int n) {
        long N = n;
		double power = 1;
		
		if(n < 0){
			x = 1 / x;
			N = -N;
		}
		
		while(N > 0){
			if(N % 2 == 1){
				power *= x;
			}
			
			x *= x;
			N/=2;
		}
		
		return power;
    }
}