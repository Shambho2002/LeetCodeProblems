class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
		
		char[] arr = s.toCharArray();
		String result = "";
		
		for(int i = 0; i < arr.length; i++){
			if(Character.isLetterOrDigit(arr[i])){
				result = result + Character.toLowerCase(arr[i]);
			}
		}
		
		char[] temp = result.toCharArray();
		
		int left = 0;
		int right = temp.length - 1;
		
		while(left < right){
			
			char ch = temp[left];
			temp[left] = temp[right];
			temp[right] = ch;
			
			left++;
			right--;
			
		}
		
		String reverse = "";
		
		for(int i = 0; i< temp.length; i++){
			reverse = reverse + temp[i];
		}
		
		return result.equals(reverse);
    }
}