class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] frequency = new int[10];
		
		while(n > 0){
			int digit = n % 10;
			frequency[digit]++;
			n /= 10;
		}
		
		int minFrequency = Integer.MAX_VALUE;
		int answer = -1;
		for(int digit = 0; digit <= 9; digit++){
			if(frequency[digit] > 0){
				if(frequency[digit] < minFrequency){
					minFrequency = frequency[digit];
					answer = digit;
				}
			}
		}
		
		return answer;
    }
}