class Solution {
    public int mySqrt(int x) {

        int ans = 0;
        for(int i = 1; i<=x/i; i++){
            ans = i;
        }
        return ans;
    }
}