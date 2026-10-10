class Solution {
    public int binaryRepresentation(int num){
		int count = 0;
		
		while(num != 0){
			int bit = num % 2;
			if(bit == 1){
				count++;
			}
			num = num / 2;
		}
		return count;
	}
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
		
		for(int i = left; i <= right; i++){
			int bits = binaryRepresentation(i);
			int prime = 0;
			
			if(bits < 2){
				continue;
			}
			
			for(int j = 2; j <= bits / 2; j++){
				if(bits % j == 0){
					prime++;
					break;
				}
			}
			
			if(prime == 0){
				count++;
			}
		}
		
		return count;
    }
}