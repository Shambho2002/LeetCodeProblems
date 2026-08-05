class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];
		boolean[] seen = new boolean[arr.length + 1];
		
		for(int i = 0; i<arr.length; i++){
			freq[arr[i]+1000]++;
		}
		
		for(int i = 0; i<freq.length; i++){
			if(freq[i] != 0){
				if(seen[freq[i]]){
					return false;
				}
				seen[freq[i]] = true;
			}
		}
		
		return true;
    }
}