class Solution {
    public boolean checkPalindrome(String s, int left, int right){
		
		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
    public boolean validPalindrome(String s) {
        int left = 0;
		int right = s.length() - 1;
		
		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				boolean option1 = checkPalindrome(s, left+1, right);
				boolean option2 = checkPalindrome(s, left, right-1);
				return option1 || option2;
			}
			left++;
			right--;
		}
		return true;
    }
}