import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		
		Arrays.sort(nums);
		for(int i = nums[0]; i<nums[nums.length - 1]; i++){
			boolean flag = false;
			for(int j = 0; j<nums.length; j++){
				if(nums[j] == i){
					flag = true;
				}
			}
			
			if(!flag){
				list.add(i);
			}
		}
		
		return list;
    }
}