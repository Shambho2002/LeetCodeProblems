class Solution {
    public int[] diStringMatch(String s) {
        int low = 0;
		int high = s.length();
		
		int[] answer = new int[s.length() + 1];
		
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch == 'I'){
				answer[i] = low;
				low++;
			}
			else{
				answer[i] = high;
				high--;
			}
		}
		
		answer[s.length()] = low;
		return answer;
    }
}