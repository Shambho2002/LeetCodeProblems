class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
		
        int count = words.length;
		
		for(int i = 0; i<words.length; i++){
			
			boolean canType = true;
			
			for(int j = 0; j<words[i].length(); j++){
				
				char ch = words[i].charAt(j);
				
				if(brokenLetters.indexOf(ch) != -1){
					canType = false;
					break;
				}
			}
			
			if(!canType){
				count--;
			}
		}
		
		return count;
    }
}