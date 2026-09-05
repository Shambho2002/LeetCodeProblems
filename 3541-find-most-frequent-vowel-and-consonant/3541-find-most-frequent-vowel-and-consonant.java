class Solution {
    public int maxFreqSum(String s) {
        int[] frequency = new int[26];
		
		// count frequency
		for(int i = 0; i<s.length(); i++){
			frequency[s.charAt(i) - 'a']++;
		}
		
		int vowelMax = 0;
		int consonantMax = 0;
		
		// Find maximum vowel and consonant frequency
		for(int i = 0; i<26; i++){
			char ch = (char) (i + 'a');
			
			if(ch == 'a' || ch == 'e' || ch == 'i' || 
				ch == 'o' || ch == 'u'){
				
				vowelMax = Math.max(vowelMax, frequency[i]);
			}
			else{
				consonantMax = Math.max(consonantMax, frequency[i]);
			}
		}
		
		return vowelMax + consonantMax;
    }
}