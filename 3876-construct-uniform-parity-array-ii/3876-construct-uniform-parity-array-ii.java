class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestOdd = Integer.MAX_VALUE;

        // Find the smallest odd number
        for (int x : nums1) {

            if (x % 2 != 0) {
                smallestOdd = Math.min(smallestOdd, x);
            }
        }

        // If there is no odd number,
        // all numbers are already even
        if (smallestOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Try to make every even number odd
        for (int x : nums1) {

            // Already odd
            if (x % 2 != 0) {
                continue;
            }

            // x is even.
            // Need a smaller odd number.
            if (x <= smallestOdd) {
                return false;
            }
        }

        return true;
    }
}