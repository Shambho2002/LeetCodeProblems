class Solution {
    public void backtrack(List<String> result, String current, int open, int close, int n){
		if(open == n && close == n){
			result.add(current);
		}
		
		// Add '('
		if(open < n){
			backtrack(result, current + "(", open + 1, close, n);
		}
		
		// Add ')'
		if(close < open){
			backtrack(result, current + ")", open, close + 1, n);
		}
	}
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
		backtrack(result, "", 0, 0, n);
		return result;
    }
}