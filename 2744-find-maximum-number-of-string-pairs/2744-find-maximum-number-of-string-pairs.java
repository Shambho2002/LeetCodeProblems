class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for(int i = 0; i<words.length; i++){
			char[] arr = words[i].toCharArray();
			int left = 0;
			int right = arr.length - 1;
			while(left < right){
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
			for(int j = i+1; j<words.length; j++){
				if(new String(arr).equals(words[j])){
					count++;
				}
			}
		}
		return count;
    }
}