class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        // Step 1: Build suffix array
        Integer[] sa = new Integer[n];

        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = nums[i];
        }

        for (int k = 1; k < n; k *= 2) {

            final int len = k;
            final int[] r = rank;

            Arrays.sort(sa, (a, b) -> {

                if (r[a] != r[b]) {
                    return Integer.compare(r[a], r[b]);
                }

                int ra = (a + len < n) ? r[a + len] : -1;
                int rb = (b + len < n) ? r[b + len] : -1;

                return Integer.compare(ra, rb);
            });

            int[] newRank = new int[n];

            newRank[sa[0]] = 0;

            for (int i = 1; i < n; i++) {

                int a = sa[i - 1];
                int b = sa[i];

                int a1 = rank[a];
                int b1 = rank[b];

                int a2 = (a + k < n) ? rank[a + k] : -1;
                int b2 = (b + k < n) ? rank[b + k] : -1;

                newRank[b] = newRank[a];

                if (a1 != b1 || a2 != b2) {
                    newRank[b]++;
                }
            }

            rank = newRank;

            if (rank[sa[n - 1]] == n - 1) {
                break;
            }
        }

        // Step 2: Build LCP array using Kasai's algorithm

        int[] lcp = new int[n];
        int[] position = new int[n];

        for (int i = 0; i < n; i++) {
            position[sa[i]] = i;
        }

        int h = 0;

        for (int i = 0; i < n; i++) {

            int pos = position[i];

            if (pos == 0) {
                h = 0;
                continue;
            }

            int j = sa[pos - 1];

            while (i + h < n &&
                   j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[pos] = h;

            if (h > 0) {
                h--;
            }
        }

        // Step 3: Find minimum unique subarray length

        int ans = n;

        for (int i = 0; i < n; i++) {

            int maxLcp = 0;

            if (i > 0) {
                maxLcp = Math.max(maxLcp, lcp[i]);
            }

            if (i < n - 1) {
                maxLcp = Math.max(maxLcp, lcp[i + 1]);
            }

            int uniqueLength = maxLcp + 1;

            if (uniqueLength <= n - sa[i]) {
                ans = Math.min(ans, uniqueLength);
            }
        }

        return ans;
    }
}