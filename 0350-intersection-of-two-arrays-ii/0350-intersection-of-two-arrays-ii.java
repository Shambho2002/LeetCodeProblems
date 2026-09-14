class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
		
		// count elements of nums1
		for(int num: nums1){
			freq[num]++;
		}
		
        List<Integer> list = new ArrayList<Integer>();
		
		// Check elements of nums2
		for(int num: nums2){
			if(freq[num] > 0){
				list.add(num);
				freq[num]--;
			}
		}
		
		// convert List to int[]
		int[] ans = new int[list.size()];
		for(int i = 0; i<list.size(); i++){
			ans[i] = list.get(i);
		}
		return ans;
    }
}