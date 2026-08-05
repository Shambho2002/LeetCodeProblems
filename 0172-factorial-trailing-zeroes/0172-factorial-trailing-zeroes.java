class Solution {
    public int trailingZeroes(int n) { // 25
        
        int count = 0; // 6

        while(n > 0){ // 0 > 0 false
            n = n / 5; // 1 / 5 == 0
            count = count + n; // 0
        }

        return count; // 6

    }
}