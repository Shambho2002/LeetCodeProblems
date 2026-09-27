class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
				int digit = s.charAt(i) - '0';
				sb.append((char)(s.charAt(i - 1) + digit));
			}
			else{
				sb.append(s.charAt(i));
			}
		}
		return new String(sb);
    }
}