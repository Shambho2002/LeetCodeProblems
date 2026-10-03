class Solution {
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0;
		
		for(char ch: s.toCharArray()){
			if(ch == '1'){
				countOnes++;
			}
		}
		
		int countZeros = s.length() - countOnes;
		
		StringBuilder result = new StringBuilder();
		
		// Put all 1s except one at the beginning
		for(int i = 1; i < countOnes; i++){
			result.append(1);
		}
		
		// put all 0s in the middle
		for(int i = 1; i <= countZeros; i++){
			result.append(0);
		}
		
		// Last digit must be 1 to make the number odd
		result.append(1);
		
		return new String(result);
    }
}