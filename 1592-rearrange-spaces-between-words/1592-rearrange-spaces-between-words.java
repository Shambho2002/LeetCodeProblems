class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
		
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i) == ' '){
				spaces++;
			}
		}
		
		// get words
		String[] words = text.trim().split("\\s+");
		
		if(words.length == 1){
			String result = words[0];
			
			for(int i = 0; i < spaces; i++){
				result += " ";
			}
			return result;
		}
		
		int between = spaces / (words.length - 1);
		int extra = spaces % (words.length - 1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< words.length; i++){
			sb.append(words[i]);
			if(i != words.length - 1){
				for(int j = 0; j < between; j++){
					sb.append(" ");
				}
			}
		}
		
		for(int i = 0; i<extra; i++){
			sb.append(" ");
		}
		
		return sb.toString();
    }
}