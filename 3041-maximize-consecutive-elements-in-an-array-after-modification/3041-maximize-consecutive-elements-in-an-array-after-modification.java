class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
		
		HashMap<Integer, Integer> dp = new HashMap<>();
		
		int ans = 0;
		
		for(int x : nums){
			// Option 1: Increase current element to x + 1
			dp.put(x + 1,
				Math.max(dp.getOrDefault(x + 1, 0),
						dp.getOrDefault(x, 0) + 1));
				
			// Option 2: Keep current element as x
			dp.put(x,
				Math.max(dp.getOrDefault(x, 0),
						dp.getOrDefault(x - 1, 0) + 1));
						
			ans = Math.max(ans, 
				Math.max(dp.get(x), dp.get(x + 1)));
		}
		
		return ans;
    }
}