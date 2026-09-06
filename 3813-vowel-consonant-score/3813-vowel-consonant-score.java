class Solution {
    public int vowelConsonantScore(String s) {
        int vowels = 0;
		int consonants = 0;
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
				if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || 
					s.charAt(i) == 'o' || s.charAt(i) == 'u'){
					vowels++;
				}
				else{
					consonants++;
				}
			}
		}
		
		if(vowels != 0 && consonants != 0){
			return vowels / consonants;
		}
		else{
			return 0;
		}
    }
}