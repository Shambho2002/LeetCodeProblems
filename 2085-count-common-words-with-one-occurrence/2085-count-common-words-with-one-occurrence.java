class Solution {
    public int countWords(String[] words1, String[] words2) {
        int count = 0;
		for(int i = 0; i<words1.length; i++){
			
			int occurrences1 = 0;
			int occurrences2 = 0;
			
			for(int j = 0; j<words1.length; j++){
				if(words1[i].equals(words1[j])){
					occurrences1++;
				}
			}
			
			for(int j = 0; j<words2.length; j++){
				if(words1[i].equals(words2[j])){
					occurrences2++;
				}
			}
			
			if(occurrences1 == 1 && occurrences2 == 1){
				count++;
			}
		}
		
		return count;
    }
}