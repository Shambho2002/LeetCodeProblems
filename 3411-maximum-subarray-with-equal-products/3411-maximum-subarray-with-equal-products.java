class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
		int maxLength = 0;
		
		for(int i = 0; i < n; i++){
			int product = 1;
			int gcdValue = 0;
			int lcmValue = 1;
			
			for(int j = i; j < n; j++){
				product = product * nums[j];
				gcdValue = GCD(gcdValue, nums[j]);
				lcmValue = LCM(lcmValue, nums[j]);
				
				if(product == gcdValue * lcmValue){
					int currentLength = j - i + 1;
					maxLength = Math.max(maxLength, currentLength);
				}
			}
		}
		
		return maxLength;
    }

    private int GCD(int a, int b){
		while(b != 0){
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		
		return a;
	}

    private int LCM(int a, int b){
		return (a / GCD(a, b)) * b;
	}
}