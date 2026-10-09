class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
		
		for(int i = 0; i<nums.length; i++){
			arr[i][0] = nums[i];
			arr[i][1] = i;
		}
		
		Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
		
        int left = 0;
		int right = arr.length - 1;
		
		while(left < right){
			int sum = arr[left][0] + arr[right][0];
			
			if(sum > target){
				right--;
			}
			else if(sum < target){
				left++;
			}
			else {
				return new int[]{arr[left][1], arr[right][1]};
			}
		}
		return new int[]{};
    }
}