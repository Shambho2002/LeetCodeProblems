class Solution {
    static class MedianData{
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int size = 0;
		long sum = 0;
		
		void add(int val){
			map.merge(val, 1, Integer::sum);
			size++;
			sum += val;
		}
		
		void remove(int val){
			map.merge(val, -1, Integer::sum);
			if(map.get(val) == 0){
				map.remove(val);
			}
			size--;
			sum -= val;
		}
		
		int getMin(){
			return map.firstKey();
		}
		
		int getMax(){
			return map.lastKey();
		}
	}
	
	private static final long INF = Long.MAX_VALUE / 4;
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
		
		long[] cost = getWindowCosts(nums, x);
		Long[][] memo = new Long[n + 1][k + 1];
		
		return solve(0, k, x, n, cost, memo);
    }

    private static long solve(int i, int k, int x, int n, long[] cost, Long[][] memo){
		if(k == 0){
			return 0;
		}
		
		if(i >= n || n - i < k * x){
			return INF;
		}
		
		if(memo[i][k] != null){
			return memo[i][k];
		}
		
		// Option 1: Skip this index
		long skip = solve(i + 1, k, x, n, cost, memo);
		
		// Option 2: Select the window starting at 1
		long take = cost[i] + solve(i + x, k - 1, x, n, cost, memo);
		
		return memo[i][k] = Math.min(skip, take);
	}
	
	private static long[] getWindowCosts(int[] nums, int x) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        MedianData lower = new MedianData();
        MedianData upper = new MedianData();

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            // Add to the appropriate half
            if (lower.size == 0 || val <= lower.getMax()) {
                lower.add(val);
            } else {
                upper.add(val);
            }

            // Keep lower half equal in size to upper,
            // or larger by one element.
            if (lower.size > upper.size + 1) {
                int move = lower.getMax();
                lower.remove(move);
                upper.add(move);
            } else if (lower.size < upper.size) {
                int move = upper.getMin();
                upper.remove(move);
                lower.add(move);
            }

            // Remove the element leaving the window
            if (i >= x) {
                int out = nums[i - x];

                if (lower.map.containsKey(out)) {
                    lower.remove(out);
                } else {
                    upper.remove(out);
                }

                // Rebalance after removal
                if (lower.size > upper.size + 1) {
                    int move = lower.getMax();
                    lower.remove(move);
                    upper.add(move);
                } else if (lower.size < upper.size) {
                    int move = upper.getMin();
                    upper.remove(move);
                    lower.add(move);
                }
            }

            // Calculate cost for each complete window
            if (i >= x - 1) {
                int start = i - x + 1;
                long median = lower.getMax();

                cost[start] =
                    median * lower.size - lower.sum
                    + upper.sum - median * upper.size;
            }
        }

        return cost;	
	}
}