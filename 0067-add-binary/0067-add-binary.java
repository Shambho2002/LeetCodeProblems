class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
		int j = b.length() - 1;
		
		int carry = 0;
		String result = "";
		
		while(i >= 0 || j >= 0 || carry != 0){
			int sum = carry;
			if(i >= 0){
				sum = sum + (a.charAt(i) - '0');
				i--;
			}
			
			if(j >= 0){
				sum = sum + (b.charAt(j) - '0');
				j--;
			}
			
			int digit = sum % 2;
			carry = sum / 2;
			
			result = result + digit;
		}
		
		String reverse = "";
		
		for(int x = result.length() - 1; x >= 0; x--){
			reverse = reverse + result.charAt(x);
		}
		
		return reverse;
    }
}