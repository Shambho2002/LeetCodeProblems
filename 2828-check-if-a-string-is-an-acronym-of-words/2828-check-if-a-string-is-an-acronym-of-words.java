class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder result = new StringBuilder();
		
		for(int i = 0; i<words.size(); i++){
			result.append(words.get(i).charAt(0));
		}
		
		return result.toString().equals(s);
    }
}