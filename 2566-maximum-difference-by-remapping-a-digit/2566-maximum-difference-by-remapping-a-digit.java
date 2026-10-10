class Solution {
    public int minMaxDifference(int num) {
        String str = String.valueOf(num);
		
		// Find maximum value
		char maxDigit = ' ';
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != '9'){
				maxDigit = str.charAt(i);
				break;
			}
		}
		
		int maxNum = num;
		if(maxDigit != ' '){
			maxNum = Integer.parseInt(str.replace(maxDigit, '9'));
		}
		
		// Find minimum value
		char minDigit = str.charAt(0);
		int minNum = Integer.parseInt(str.replace(minDigit, '0'));
		return maxNum - minNum;
    }
}