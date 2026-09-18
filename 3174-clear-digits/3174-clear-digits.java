class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(ch >= '0' && ch <= '9'){
				// remove closest non-digit character
				stack.pop();
			}
			else{
				// store letter
				stack.push(ch);
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<stack.size(); i++){
			sb.append(stack.get(i));
		}
		return new String(sb);
    }
}