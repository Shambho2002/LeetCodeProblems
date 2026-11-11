class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Option 1: Buy individual items
        long costA = (long) need1 *  cost1 + (long) need2 * cost2;
		
		// Option 2: Buy type 3 for common requirements
		long common = Math.min(need1, need2);
		
		long costB = (long) common * costBoth
					+ (long) (need1 - common) * cost1
					+ (long) (need2 - common) * cost2;
		
		// Option 3: Buy only type 3 items
		int commonNeeded = Math.max(need1, need2);
		
		long costC = (long) commonNeeded * costBoth;
		
		// Find minimum among all three options
		long answer = Math.min(costA, Math.min(costB, costC));
		
		return answer;
    }
}