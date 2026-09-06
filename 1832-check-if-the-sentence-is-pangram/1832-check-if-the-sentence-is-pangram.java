class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] alphabet = new int[26];
		
		for(int i = 0; i<sentence.length(); i++){
			if(sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z'){
				alphabet[((int)sentence.charAt(i) - 'a')]++;
			}
		}
		
		for(int i = 0; i<alphabet.length; i++){
			if(alphabet[i] == 0){
				return false;
			}
		}
		
		return true;
    }
}