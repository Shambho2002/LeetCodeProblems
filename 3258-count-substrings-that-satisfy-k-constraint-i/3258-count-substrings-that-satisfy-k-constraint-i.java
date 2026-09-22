class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0;
		int zeroCount = 0;
		int oneCount = 0;
		int answer = 0;
		
		for(int right = 0; right<s.length(); right++){
			
			// Add current character
			if(s.charAt(right) == '0'){
				zeroCount++;
			}
			else{
				oneCount++;
			}
			
			// Window is invalid when both exceed k
			while(zeroCount > k && oneCount > k){
				
				if(s.charAt(left) == '0'){
					zeroCount--;
				}
				else{
					oneCount--;
				}
				
				left++;
			}
			
			// Number of valid substring ending at right
			answer += right - left + 1;
		}
		return answer;
    }
}