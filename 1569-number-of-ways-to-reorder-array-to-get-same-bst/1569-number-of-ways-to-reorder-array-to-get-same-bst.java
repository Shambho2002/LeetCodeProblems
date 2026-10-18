class Solution {
    static final int MOD = 1_000_000_007;
    static long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        return (int) ((countWays(nums) - 1 + MOD) % MOD);
    }

    public static long countWays(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return 1;
        }

        int root = nums[0];

        int[] left = new int[n - 1];
        int[] right = new int[n - 1];

        int leftSize = 0;
        int rightSize = 0;

        // Split into left and right subtrees
        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left[leftSize++] = nums[i];
            } else {
                right[rightSize++] = nums[i];
            }
        }

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        System.arraycopy(left, 0, leftArr, 0, leftSize);
        System.arraycopy(right, 0, rightArr, 0, rightSize);

        // Count ways to interleave left and right subtrees
        long ways = comb[leftSize + rightSize][leftSize];

        ways = (ways * countWays(leftArr)) % MOD;
        ways = (ways * countWays(rightArr)) % MOD;

        return ways;
    }
}