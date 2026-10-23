class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
		
		for(int i = 0; i < nums.length; i++){
			int num = nums[i];
			int maxDigit = 0;
			int digitCount = 0;
			
			while(num > 0){
				num /= 10;
				digitCount++;
			}
			
			while(nums[i] > 0){
				int digit = nums[i] % 10;
				if(digit > maxDigit){
					maxDigit = digit;
				}
				nums[i] /= 10;
			}
			
			int encrypt = 0;
			for(int j = 1; j <= digitCount; j++){
				encrypt = encrypt * 10 + maxDigit;
			}
			
			sum += encrypt;
		}
		
		return sum;
    }
}