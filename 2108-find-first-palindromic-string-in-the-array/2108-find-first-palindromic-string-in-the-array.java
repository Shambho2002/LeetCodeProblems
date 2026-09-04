class Solution {
    public boolean isPalidrome(String word){
		
		char[] chArr = word.toCharArray();
		
		int left = 0;
		int right = chArr.length - 1;
		
		while(left < right){
			
			if(chArr[left] != chArr[right]){
				return false;
			}
			left++;
			right--;
		}
		
		return true;
		
	}
    public String firstPalindrome(String[] words) {
        for(int i = 0; i<words.length; i++){
			
			if(isPalidrome(words[i])){
				return words[i];
			}
			
		}
		
		return "";
    }
}