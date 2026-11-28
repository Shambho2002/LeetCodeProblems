class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Step 1: Find maximum factor and minimum price
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;

        int[] freq = new int[n + 1];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            maxFactor = Math.max(maxFactor, factor);
            minPrice = Math.min(minPrice, price);

            freq[factor]++;
        }

        // Step 2: Count items having multiple factors
        // freq[i] = number of item types whose factor
        // is divisible by i

        for (int i = 1; i <= maxFactor; i++) {

            for (int j = 2 * i; j <= maxFactor; j += i) {

                freq[i] += freq[j];
            }
        }

        // Step 3: Sort items by price
        Arrays.sort(items, Comparator.comparingInt(a -> a[1]));

        long answer = 0;
        long remainingBudget = budget;

        // Step 4: Purchase beneficial double-value copies
        for (int[] item : items) {

            long factor = item[0];
            long price = item[1];

            // No benefit if price is more than
            // twice the cheapest price
            if (price > 2 * minPrice) {
                break;
            }

            // Exclude the current item itself
            long freeCount = freq[(int) factor] - 1;

            if (freeCount <= 0) {
                continue;
            }

            // Maximum useful copies we can purchase
            long buy = Math.min(
                freeCount,
                remainingBudget / price
            );

            answer += buy * 2;

            remainingBudget -= buy * price;
        }

        // Step 5: Spend remaining budget on cheapest items
        answer += remainingBudget / minPrice;

        return (int) answer;
    }
}