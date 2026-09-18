class Solution {
    public String removeOuterParentheses(String s) {
        StringBuffer sb = new StringBuffer(); // '()()()'
		int depth = 0; // 0
		
		for(int i = 0; i<s.length(); i++){ // i = 9
			char ch = s.charAt(i); // '(' == true
			if(ch == '('){ // true
				if(depth > 0){ // 1 > 0 == true
					sb.append(ch); // '('
				}
				depth++; // depth += 1;
			}
			else{
				depth--; // depth -= 1
				if(depth > 0){ // 0 > 0 == false
					sb.append(ch); // ')'
				}
			}
		}
		return new String(sb);
    }
}