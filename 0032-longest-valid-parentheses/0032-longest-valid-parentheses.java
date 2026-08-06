class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        
		Stack<Integer> stack = new Stack<>();
		
		stack.push(-1);
		int maxLength = 0;
		
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push(i);
			}
			else{
				stack.pop();
				
				if(stack.isEmpty()){
					stack.push(i);
				}
				else{
					maxLength = Math.max(maxLength, i - stack.peek());
				}
			}
		}
		
		return maxLength;
    }
}