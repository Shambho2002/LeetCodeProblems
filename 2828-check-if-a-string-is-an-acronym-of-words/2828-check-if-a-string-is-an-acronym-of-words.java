class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String result = "";
		for(int i = 0; i<words.size(); i++){
			result += words.get(i).charAt(0);
		}
		
		return result.equals(s);
    }
}