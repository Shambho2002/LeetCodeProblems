class Solution {
    public int firstUniqChar(String s) {
        int[] result = new int[256];
        
		char[] arr = s.toCharArray();
		
		for(int i = 0; i<arr.length; i++){
			result[arr[i]]++;
		}
		
		for(int i = 0; i<arr.length; i++){
			if(result[arr[i]] == 1){
				return i;
			}
		}
		
		return -1;
    }
}