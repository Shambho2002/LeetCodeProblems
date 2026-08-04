class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.trim().split("\\s+");
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i<strArr.length; i++){
			String word = strArr[i];
			
			char[] chArr = word.toCharArray();
			
			int left = 0;
			int right = chArr.length - 1;
		
			while(left < right){
			
				char temp = chArr[left];
				chArr[left] = chArr[right];
				chArr[right] = temp;
				left++;
				right--;
				
			}
			
			for(char ch: chArr){
				sb.append(ch);
			}
			
			if(i < strArr.length - 1){
				sb.append(" ");
			}
			
		}
		
		
		return new String(sb);
    }
}