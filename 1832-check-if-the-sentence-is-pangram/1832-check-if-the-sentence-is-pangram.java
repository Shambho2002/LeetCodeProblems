class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
		int unique = 0;
		
		for(int i = 0; i<sentence.length(); i++){
			int index = sentence.charAt(i) - 'a';
			if(!seen[index]){
				seen[index] = true;
				unique++;
				if(unique == 26){
					return true;
				}
			}
		}
		return false;
    }
}