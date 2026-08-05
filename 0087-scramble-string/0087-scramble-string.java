class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)){
			return true;
		}
		
		if(s1.length() != s2.length()){
			return false;
		}
		
		// Memorization check
		String key = s1 + "#" + s2;
		
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		
		// Character Frequency Check
		int[] count = new int[26];
		
		for(int i = 0; i<s1.length(); i++){
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		
		for(int num: count){
			if(num != 0){
				memo.put(key, false);
				return false;
			}
		}
		
		int n = s1.length();
		
		// Try every possible split
		for(int i = 1; i<n; i++){
			
			// Case 1: No Swap
			if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
				memo.put(key, true);
				return true;
			}
			
			// Case 2: Swap
			if(isScramble(s1.substring(0,i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n - i))){
				memo.put(key,true);
				return true;
			}
		}
		
		memo.put(key, false);
		return false;
    }
}