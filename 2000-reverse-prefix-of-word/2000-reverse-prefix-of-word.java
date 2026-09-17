class Solution {
    public String reversePrefix(String word, char ch) {
        char[] words = word.toCharArray();
		
		int index = -1;
		for(int i = 0; i<words.length; i++){
			if(words[i] == ch){
				index = i;
				break;
			}
		}
		
		if(index != -1){
			int left = 0;
			int right = index;
			
			while(left < right){
				char temp = words[left];
				words[left] = words[right];
				words[right] = temp;
				left++;
				right--;
			}
		}
		return new String(words);
    }
}