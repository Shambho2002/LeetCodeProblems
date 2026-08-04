class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
		for(int i = 0; i<s.length(); i++){
			lastIndex[s.charAt(i) - 'a'] = i;
		}
		
		boolean[] visited = new boolean[26];
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i<s.length(); i++){
			
			char ch = s.charAt(i);
			
			// Skip if already added
			if(visited[ch - 'a']){
				continue;
			}
			
			while(!stack.isEmpty() && ch < stack.peek() && lastIndex[stack.peek() - 'a'] > i){
				char removed = stack.pop();
				visited[removed - 'a'] = false;
			}
			
			// add current character
			stack.push(ch);
			visited[ch - 'a'] = true;
			
		}
		
		StringBuilder result = new StringBuilder();
		for(char ch : stack){
			result.append(ch);
		}
		
		return result.toString();
    }
}