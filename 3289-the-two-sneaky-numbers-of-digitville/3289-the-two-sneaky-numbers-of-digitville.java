import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i<nums.length; i++){
			boolean flag = false;
			for(int k = 0; k<i; k++){
				if(nums[i] == nums[k]){
					flag = true;
					break;
				}
			}
			
			if(flag){
				list.add(nums[i]);
			}
		}
		
		int[] ans = new int[list.size()];
		for(int i = 0; i<list.size(); i++){
			ans[i] = list.get(i);
		}
		
		return ans;
    }
}