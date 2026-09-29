class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder(); // rij
		
		for(String word: words){
			
			int totalWeight = 0; // 16
			
			for(char ch: word.toCharArray()){ // z
				
				int index = ch - 'a'; // 122 - 97 = 25
				totalWeight = totalWeight + weights[index]; // 14 + weights[24] = 14 + 2 = 16
				
			}
			
			int remainder = totalWeight % 26; // 16 % 26 = 16
			char mappedCharacter = (char) ('z' - remainder); // 122 - 16 = 106 = j
			result.append(mappedCharacter); // j
			
		}
		
		return new String(result); // rij
    }
}