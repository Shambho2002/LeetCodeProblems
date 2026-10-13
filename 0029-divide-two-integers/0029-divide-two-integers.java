class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
		
		boolean negative = (dividend < 0) != (divisor < 0);
		
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		
		int quotient = 0;
		
		while(a >= b){
			long tempDivior = b;
			long multiple = 1;
			
			while(a >= (tempDivior << 1)){
				tempDivior <<= 1;
				multiple <<= 1;
			}
			
			a -= tempDivior;
			quotient += multiple;
		}
		
		if(negative){
			quotient = -quotient;
		}
		
		return (int) quotient;
    }
}