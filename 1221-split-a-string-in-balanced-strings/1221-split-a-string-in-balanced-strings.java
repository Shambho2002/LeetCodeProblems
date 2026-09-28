class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
		int balance = 0;
		
		for(int i = 0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(ch == 'L'){
				balance++;
			}
			else {
				balance--;
			}
			
			if(balance == 0){
				count++;
			}
		}
		
		return count;
    }
}