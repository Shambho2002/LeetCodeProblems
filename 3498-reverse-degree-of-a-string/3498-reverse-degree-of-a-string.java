class Solution {
    public int reverseDegree(String s) {
        int degree = 0;
		for(int i = 0; i<s.length(); i++){
			int stringPosition = i + 1;
			int reversePosition = 'z' - s.charAt(i) + 1;
			degree += reversePosition * stringPosition;
		}
		return degree;
    }
}