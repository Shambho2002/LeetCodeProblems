class Solution {
    public boolean isPalindrome(int x) {

        if(x < 0) return false; // negative numbers are not palindrome

        int original = x; // store original value
        int digit = 0;
        int reverse = 0; // 121
        while(x!=0){
            digit = x%10; // 1
            reverse = reverse * 10 + digit; // 12 * 10 + 1 = 120 + 1 = 121
            x = x/10; // 0
        }

        return original == reverse;
        
    }
}