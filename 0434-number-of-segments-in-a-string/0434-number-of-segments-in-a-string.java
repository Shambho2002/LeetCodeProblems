class Solution {
    public int countSegments(String s) {
        int count = 0;
		
		char[] arr = s.toCharArray();
		
		for(int i = 0; i<arr.length; i++){
			
			if(arr[i] != ' ' && (i == 0 || arr[i-1] == ' ')){
				count++;
			}
			
		}
		
		return count;
    }
}