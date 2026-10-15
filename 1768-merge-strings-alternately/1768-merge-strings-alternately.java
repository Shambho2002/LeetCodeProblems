class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
		int i = 0;
		while(i < word1.length() && i < word2.length()){
			result.append(word1.charAt(i));
			result.append(word2.charAt(i));
			i++;
		}
		
		// Append remaining character from word1
		while(i < word1.length()){
			result.append(word1.charAt(i));
			i++;
		}
		
		// Append remaining character from word2
		while(i < word2.length()){
			result.append(word2.charAt(i));
			i++;
		}
		
		return result.toString();
    }
}