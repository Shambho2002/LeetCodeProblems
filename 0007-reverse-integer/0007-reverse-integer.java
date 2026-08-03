import java.lang.*;
class Solution {
    public int reverse(int x) {

        int reverse = 0; // 321

        while(x!=0){
            int digit = x%10; // 1
            x = x/10; // 0

            // Check overflow before multiplying 
            if(reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MIN_VALUE / 10){
                return 0;
            }

            reverse = reverse * 10 + digit; // 32 * 10 + 1 = 320 + 1 = 321

        }

        return reverse;
    }
}