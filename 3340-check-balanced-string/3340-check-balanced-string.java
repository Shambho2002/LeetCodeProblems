class Solution {
    public boolean isBalanced(String num) {
        int evenSum = 0;
		int oddSum = 0;
		
		for(int i = 0; i<num.length(); i++){
			if(i%2 == 0){
				evenSum += (int)num.charAt(i) - '0';
			}
			else{
				oddSum += (int)num.charAt(i) - '0';
			}
		}
		
		return evenSum == oddSum;
    }
}