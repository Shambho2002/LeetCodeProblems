class Solution {
    public int minElement(int[] nums) {
        int[] arr = new int[nums.length];
		
		for(int i = 0; i<nums.length; i++){
			int sum = 0;
			int temp = nums[i];
			while(temp != 0){
				sum += temp % 10;
				temp /= 10;
			}
			arr[i] = sum;
		}
		
		int min = Integer.MAX_VALUE;
		for(int num: arr){
			if(num < min){
				min = num;
			}
		}
		
		return min;
    }
}