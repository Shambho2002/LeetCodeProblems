class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String result = "";
		for(int i = 0; i<words.size(); i++){
			String word = words.get(i);
			for(int j = 0; j<word.length(); j++){
				if(word.charAt(j) >= 'a' && word.charAt(j) <= 'z'){
					result += word.charAt(j);
					break;
				}
			}
		}
		
		return result.equals(s);
    }
}