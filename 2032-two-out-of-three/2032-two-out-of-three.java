import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int x = 1; x <= 100; x++){
			int count = 0;
			
			// check in nums1
			for(int num: nums1){
				if(num == x){
					count++;
					break;
				}
			}
			
			// check in nums2
			for(int num: nums2){
				if(num == x){
					count++;
					break;
				}
			}
			
			// check in nums3
			for(int num: nums3){
				if(num == x){
					count++;
					break;
				}
			}
			
			// present in at least 2 array
			if(count >= 2){
				list.add(x);
			}
		}
		
		return list;
    }
}