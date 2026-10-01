class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10]; // 0 1 2 0 0 0 0 0 0 0
		
		while(n > 0){ // 0 > 0 = false
			int digit = n % 10; // 1
			freq[digit] = freq[digit] + 1; // freq[1] = freq[1] + 1; freq[1] = 0 + 1;
			n = n / 10; // 0
		}
		
		int score = 0; // 5
		
		for(int i = 0; i < freq.length; i++){ // 2
			score = score + (i * freq[i]); // score = 1 + (2 * 2); = 1 + 4 = 5
		}
		
		return score; // 5
    }
}