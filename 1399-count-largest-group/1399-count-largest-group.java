class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
		
		for(int i = 1; i <= n; i++){
			int num = i;
			int sum = 0;
			
			while(num > 0){
				sum += num % 10;
				num /= 10;
			}
			
			count[sum]++;
		}
		
		int max = 0;
		int result = 0;
		
		for(int size: count){
			if(size > max){
				max = size;
				result = 1;
			}
			else if(size == max && size > 0){
				result++;
			}
		}
		
		return result;
    }
}