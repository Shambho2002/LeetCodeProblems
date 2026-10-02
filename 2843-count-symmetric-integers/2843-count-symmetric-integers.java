class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
		
		for(int num = low; num <= high; num++){
			String strNum = String.valueOf(num);
			int length = strNum.length();
			
			// Odd number of digits cannot be symmetric
			if(length % 2 != 0){
				continue;
			}
			
			int half = length / 2;
			
			int firstSum = 0;
			int secondSum = 0;
			
			// First half
			for(int i = 0; i<half; i++){
				firstSum += strNum.charAt(i) - '0';
			}
			
			// Second half
			for(int i = half; i<length; i++){
				secondSum += strNum.charAt(i) - '0';
			}
			
			if(firstSum == secondSum){
				count++;
			}
		}
		
		return count;
    }
}