class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        // Process cells in topological order.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 || grid[i][j] == 1) {
                    continue;
                }

                long ways = dp[i][j];

                // Move right, reflecting through consecutive mirrors.
                int x = i;
                int y = j + 1;
                boolean movingDown = false;

                while (x < m && y < n && grid[x][y] == 1) {
                    if (!movingDown) {
                        x++;
                    } else {
                        y++;
                    }
                    movingDown = !movingDown;
                }

                if (x < m && y < n) {
                    dp[x][y] = (dp[x][y] + ways) % MOD;
                }

                // Move down, reflecting through consecutive mirrors.
                x = i + 1;
                y = j;
                boolean movingRight = false;

                while (x < m && y < n && grid[x][y] == 1) {
                    if (!movingRight) {
                        y++;
                    } else {
                        x++;
                    }
                    movingRight = !movingRight;
                }

                if (x < m && y < n) {
                    dp[x][y] = (dp[x][y] + ways) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}