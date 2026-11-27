class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Step 1: Calculate free items for every item
        int[] freeCount = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j &&
                    items[j][0] % items[i][0] == 0) {

                    freeCount[i]++;
                }
            }
        }

        // Step 2: Sort items by price in descending order
        // Keep original index to access freeCount correctly
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) ->
            Integer.compare(items[b][1], items[a][1])
        );

        // Step 3: DP for previously processed (more expensive) items
        int NEG = -1000000000;

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, NEG);

        dp[0] = 0;

        int answer = 0;
        int index = 0;

        // Step 4: Process items price group by price group
        while (index < n) {

            int price = items[order[index]][1];

            // At least one item of the current price must be selected
            int[] current = new int[budget + 1];
            Arrays.fill(current, NEG);

            // Process all items having the same price
            while (index < n &&
                   items[order[index]][1] == price) {

                int i = order[index];

                int cost = items[i][1];
                int value = 1 + freeCount[i];

                for (int b = budget; b >= cost; b--) {

                    // Select this item as the first item
                    // of the current price group
                    if (dp[b - cost] != NEG) {
                        current[b] = Math.max(
                            current[b],
                            dp[b - cost] + value
                        );
                    }

                    // Select another item from this group
                    if (current[b - cost] != NEG) {
                        current[b] = Math.max(
                            current[b],
                            current[b - cost] + value
                        );
                    }
                }

                index++;
            }

            // Step 5: Add additional copies of cheapest selected item
            for (int b = 0; b <= budget; b++) {

                if (current[b] != NEG) {

                    int remaining = budget - b;

                    answer = Math.max(
                        answer,
                        current[b] + remaining / price
                    );

                    // Make current selections available
                    // for the next, cheaper price group
                    dp[b] = Math.max(dp[b], current[b]);
                }
            }
        }

        return answer;
    }
}