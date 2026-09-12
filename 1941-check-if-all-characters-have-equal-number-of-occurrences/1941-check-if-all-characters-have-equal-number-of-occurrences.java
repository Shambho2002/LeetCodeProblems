class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] frequency = new int[26];
		
		// count frequency of each character
		int i = 0;
		while(i < s.length()){
			frequency[s.charAt(i) - 'a']++;
			i++;
		}
		
		// find frequency of first character that appeared
		int expected = 0;
		
		int j = 0;
		while(j < frequency.length){
			if(frequency[j] != 0){
				expected = frequency[j];
				break;
			}
			j++;
		}
		
		// compare all non-zero frequencies
		while(j < frequency.length){
			if(frequency[j] != 0 && frequency[j] != expected){
				return false;
			}
			j++;
		}
		
		return true;
    }
}