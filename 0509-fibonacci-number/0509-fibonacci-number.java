// Fibonacci numbers  =  0 1 1 2 3 5 8 13 

class Solution {
    public int fib(int n) {

        if(n <= 1){
            return n;
        }
        else{
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;

            for(int i = 2; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }

            return dp[n];
        }
    }
}