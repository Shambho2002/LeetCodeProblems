class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int[] frequency = new int[24]; // 2 0 0 0 0 1 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0
		int count = 0; // 2
		
		for(int i = 0; i<hours.length; i++){
			int remainder = hours[i] % 24; // 24 % 24 = 0
			
			int required = (24 - remainder) % 24; // 24 - 0 = 24 % 24 = 0
			
			count = count + frequency[required]; // count + frequency[0] = 1 + 1 = 2
			
			frequency[remainder]++; // frequency[0]++
		}
		
		return count; // 2
    }
}