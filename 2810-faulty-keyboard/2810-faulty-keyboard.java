class Solution {
    public String finalString(String s) {
        StringBuilder result = new StringBuilder();
		
		for(char ch: s.toCharArray()){
			if(ch == 'i'){
				result.reverse();
			}
			else{
				result.append(ch);
			}
		}
		
		return result.toString();
    }
}