class Solution {
    public String reversePrefix(String s, int k) {
        char[] chArr = s.toCharArray();
		
        int left = 0;
		int right = k - 1;
		
		while(left < right){
			char temp = chArr[left];
			chArr[left] = chArr[right];
			chArr[right] = temp;
			left++;
			right--;
		}
		return new String(chArr);
    }
}