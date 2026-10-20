class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int answer = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean sortable = true;
            int previousMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int end = start + k;
                int descents = 0;
                int min = nums[start];
                int max = nums[start];

                for (int j = start; j < end; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);

                    int next = start + (j - start + 1) % k;

                    if (nums[j] > nums[next]) {
                        descents++;
                    }
                }

                // This block must be sortable by rotation.
                if (descents > 1) {
                    sortable = false;
                    break;
                }

                // Consecutive sorted blocks must be in order.
                if (previousMax > min) {
                    sortable = false;
                    break;
                }

                previousMax = max;
            }

            if (sortable) {
                answer += k;
            }
        }

        return answer;
    }
}