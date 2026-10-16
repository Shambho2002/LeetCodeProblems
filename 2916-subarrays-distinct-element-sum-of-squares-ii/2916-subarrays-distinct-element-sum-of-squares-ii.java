class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] sum;
    private long[] sumSquares;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        sumSquares = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int previous = last[nums[i]];

            update(1, 0, n - 1, previous + 1, i, 1);

            answer = (answer + sumSquares[1]) % MOD;
            last[nums[i]] = i;
        }

        return (int) answer;
    }

    private void update(int node, int left, int right,
                        int ql, int qr, long delta) {
        if (ql > right || qr < left || ql > qr) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, delta);
            return;
        }

        pushDown(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr, delta);
        update(node * 2 + 1, mid + 1, right, ql, qr, delta);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSquares[node] =
            (sumSquares[node * 2] + sumSquares[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int left, int right, long delta) {
        long len = right - left + 1L;

        sumSquares[node] = (
            sumSquares[node]
            + 2L * delta % MOD * sum[node] % MOD
            + len % MOD * delta % MOD * delta % MOD
        ) % MOD;

        sum[node] = (sum[node] + len * delta) % MOD;
        lazy[node] = (lazy[node] + delta) % MOD;
    }

    private void pushDown(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        long delta = lazy[node];

        apply(node * 2, left, mid, delta);
        apply(node * 2 + 1, mid + 1, right, delta);

        lazy[node] = 0;
    }

}