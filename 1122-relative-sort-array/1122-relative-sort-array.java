class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] frequency = new int[1001];
		
		for(int i = 0; i<arr1.length; i++){
			frequency[arr1[i]]++;
		}
		
		int[] ans = new int[arr1.length];
		int index = 0;
		
		for(int x: arr2){
			
			while(frequency[x] > 0){
				ans[index] = x;
				index++;
				frequency[x]--;
			}
		}
		
		for(int i = 0; i<=1000; i++){
			
			while(frequency[i] > 0){
				ans[index] = i;
				index++;
				frequency[i]--;
			}
		}
		
		return ans;
    }
}