class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i<s.length(); i++){
			
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
				stack.push(s.charAt(i));
			}
			
			if(!stack.empty()){
				if(s.charAt(i) == '*'){
					stack.pop();
				}
			}
		}
		
		StringBuilder ans = new StringBuilder();
		
		while(!stack.empty()){
			ans.append(stack.pop());
		}
		
		return ans.reverse().toString();
    }
}