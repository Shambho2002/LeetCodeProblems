class Solution {
    public char kthCharacter(int k) {
        String word = "a";
		
		while(word.length() < k){
			String newWord = "";
			for(char ch: word.toCharArray()){
				char nextChar;
				if(ch == 'z'){
					nextChar = 'a';
				}
				else{
					nextChar = (char)(ch + 1);
				}
				
				newWord += nextChar;
			}
			word += newWord;
		}
		
		return word.charAt(k - 1);
    }
}