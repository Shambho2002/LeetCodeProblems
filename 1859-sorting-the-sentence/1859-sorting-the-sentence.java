class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        
		String[] result = new String[words.length];
		
		for(String word: words){
			int position = word.charAt(word.length() - 1) - '0';
			String originalWord = word.substring(0, word.length() - 1);
			result[position - 1] = originalWord;
		}
		
		return String.join(" ", result);
    }
}