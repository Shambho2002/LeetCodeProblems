class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
		
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right){
			if(!((arr[left] >= 'a' && arr[left] <= 'z') || (arr[left] >= 'A' && arr[left] <= 'Z'))){
				left++;
			}
			else if(!((arr[right] >= 'a' && arr[right] <= 'z') || (arr[right] >= 'A' && arr[right] <= 'Z'))){
				right--;
			}
			else{
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
        return new String(arr);
    }
}