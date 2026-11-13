class Solution {
    public int maximumSum(int[] arr) {
        // Kadane's Algorithm
        int noDeletion = arr[0];
		int oneDeletion = 0;
		
		int maxSum = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			int current = arr[i];
			
			// Delete the current element OR
			// extend a subarray where the deletion was already used
			oneDeletion = Math.max(noDeletion, oneDeletion + current);
			
			// Normal Kadane's Algorithm
			noDeletion = Math.max(current, noDeletion + current);
			
			maxSum = Math.max(maxSum, oneDeletion);
			maxSum = Math.max(maxSum, noDeletion);
		}
		
		return maxSum;
    }
}