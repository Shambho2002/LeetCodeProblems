class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length() == 2){
			return s.charAt(0) == s.charAt(1);
		}
		
		StringBuilder ans = new StringBuilder();
		int i = 0;
		int j = 1;
		while(j < s.length()){
			int a = s.charAt(i) - '0';
			int b = s.charAt(j) - '0';
			
			ans.append((a+b) % 10);
			
			i++;
			j++;
		}
		
		return hasSameDigits(ans.toString());
    }
}