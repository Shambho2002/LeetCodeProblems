class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
		
		int evenCount = 1;
		int oddCount = 0;
		int prefixSum = 0;
		int answer = 0;
		
		for(int num: arr){
			prefixSum += num;
			
			if(prefixSum % 2 == 0){
				answer = (answer + oddCount) % MOD;
				evenCount++;
			}
			else{
				answer = (answer + evenCount) % MOD;
				oddCount++;
			}
		}
		
		return answer;
    }
}