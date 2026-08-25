import java.util.Arrays;
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums); // 2,3,3,5
		
		int left = 0; // 3
		int right = nums.length - 1; // 3
		
		int max = 0; // 7
		
		while(left < right){ // left < right
			int pairSum = nums[left] + nums[right]; // 3 + 3 = 6
			
			if(pairSum > max){ // 7 > 6 == 7
				max = pairSum; // 7
			}
			
			left++;
			right--;
		}
		return max; // 7
    }
}