class Solution {
    public String reverseWords(String words){
		char[] chArr = words.toCharArray();
		
		int left = 0;
		int right = chArr.length - 1;
		
		while(left < right){
			char temp = chArr[left];
			chArr[left] = chArr[right];
			chArr[right] = temp;
			left++;
			right--;
		}
		return new String(chArr);
	}
	public String reverseSpecial(String special){
		char[] chArr = special.toCharArray();
		
		int left = 0;
		int right = chArr.length - 1;
		
		while(left < right){
			char temp = chArr[left];
			chArr[left] = chArr[right];
			chArr[right] = temp;
			left++;
			right--;
		}
		return new String(chArr);
	}
    public String reverseByType(String s) {
        String words = "";
		String special = "";
		
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
				words += s.charAt(i);
			}
			else{
				special += s.charAt(i);
			}
		}
		
		words = reverseWords(words);
		special = reverseSpecial(special);
		
		StringBuffer sb = new StringBuffer();
		
		int letterIndex = 0;
		int specialIndex = 0;
		
		// Put them back into their original positions
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
				sb.append(words.charAt(letterIndex));
				letterIndex++;
			}
			else{
				sb.append(special.charAt(specialIndex));
				specialIndex++;
			}
		}
		return new String(sb);
    }
}