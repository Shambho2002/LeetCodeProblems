class Solution {
    public String decodeMessage(String key, String message) {
        char[] mapping = new char[26];
		boolean[] visited = new boolean[26];
		
		int alphabetIndex = 0;
		
		// Build substitution table
		for(int i = 0; i<key.length(); i++){
			char ch = key.charAt(i);
			
			if(ch == ' '){
				continue;
			}
			
			int index = ch - 'a';
			
			if(!visited[index]){
				mapping[index] = (char) ('a' + alphabetIndex);
				visited[index] = true;
				alphabetIndex++;
			}
		}
		
		// Decode message
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<message.length(); i++){
			char ch = message.charAt(i);
			if(ch == ' '){
				sb.append(' ');
			}
			else{
				int index = ch - 'a';
				sb.append(mapping[index]);
			}
		}
		
		return new String(sb);
    }
}