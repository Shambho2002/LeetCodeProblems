class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){ // 3 > 3 = false
			
			StringBuilder newString = new StringBuilder(); // "135"
			
			int i = 0; // 0
			
			while(i < s.length()){ // 6 < 4 = false
				
				int sum = 0; // 5
				int j = i; // 3
				
				while(j < i + k && j < s.length()){ // 4 < 4 && 4 < 4 = false
					
					int digit = s.charAt(j) - '0'; // 5
					sum += digit; // 0 + 5 = 5
					
					j++; // +1
				}
				
				String sumString = String.valueOf(sum); // "5"
				newString.append(sumString); // "5"
				
				i = i + k; // 3 + 3 = 6
			}
			
			s = newString.toString(); // "135"
		}
		
		return s; // 135
    }
}