class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
		for(int i = 0; i<arr.length; i++){
			int currentSum = 0;
			for(int j = i; j<arr.length; j++){
				currentSum += arr[j];
				if((j - i + 1)%2 != 0){
					sum += currentSum;
				}
			}
		}
		return sum;
    }
}