class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i<nums.length; i+=2){
			int freq = nums[i];
			int val = nums[i+1];
			for(int j = 1; j<=freq; j++){
				list.add(val);
			}
		}
		
		int[] ans = new int[list.size()];
		for(int i = 0; i<list.size(); i++){
			ans[i] = list.get(i);
		}
		return ans;
    }
}