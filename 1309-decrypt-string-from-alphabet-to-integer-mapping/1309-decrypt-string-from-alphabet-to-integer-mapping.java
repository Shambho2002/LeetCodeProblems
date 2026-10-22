class Solution {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
		int i = 0;
		
		while(i < s.length()){
			int number;
			if(i + 2 < s.length() && s.charAt(i + 2) == '#'){
				number = Integer.parseInt(s.substring(i, i + 2));
				i = i + 3;
			}
			else{
				number = Integer.parseInt(s.substring(i, i + 1));
				i = i + 1;
			}
			
			char letter = (char)('a' + number - 1);
			result.append(letter);
		}
		
		return result.toString();
    }
}