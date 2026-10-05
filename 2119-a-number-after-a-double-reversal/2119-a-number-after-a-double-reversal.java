class Solution {
    public boolean isSameAfterReversals(int num) {
        int reversed1 = 0;
		int reversed2 = 0;
		int original = num;
		
		while(num != 0){
			int digit = num % 10;
			reversed1 = reversed1 * 10 + digit;
			num = num / 10;
		}
		
		while(reversed1 != 0){
			int digit = reversed1 % 10;
			reversed2 = reversed2 * 10 + digit;
			reversed1 = reversed1 / 10;
		}
		
		return original == reversed2;
    }
}