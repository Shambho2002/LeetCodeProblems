class Solution {
    public int strStr(String haystack, String needle) {
        char[] arr = haystack.toCharArray();
		char[] arr1 = needle.toCharArray();
		
		for(int i = 0; i<=arr.length - arr1.length; i++){
			int j;
			for(j = 0; j<arr1.length; j++){
				if(arr[i+j] != arr1[j]){
					break;
				}
			}
			
			if(j == arr1.length){
				return i;
			}
			
		}
		
		return -1;
    }
}