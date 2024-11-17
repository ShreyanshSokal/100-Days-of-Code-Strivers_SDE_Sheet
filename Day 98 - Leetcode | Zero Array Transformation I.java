import java.util.*;

class Solution {

    /**
     * Intuition:
     * - Use a difference array (`delta`) to efficiently handle range updates.
     * - For each query, mark the start and end+1 in the `delta` array to apply decrement later.
     * - Use prefix sums on `delta` to calculate the cumulative changes and apply them to the `nums` array.
     * - Finally, check if the updated `nums` array contains all zeros.
     * 
     * Time Complexity: O(n + q)
     * - O(q) to process all queries.
     * - O(n) to apply changes and check for all zeros.
     * 
     * Space Complexity: O(n)
     * - O(n) for the `delta` array.
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] delta = new int[n + 1];  // Difference array to handle range updates efficiently.

        // Process each query
        for (int[] query : queries) {
            int l = query[0], r = query[1];

            // Decrement the range in the difference array
            delta[l]--;  // Decrement start of the range
            if (r + 1 < delta.length) {
                delta[r + 1]++;  // Increment position right after the end of the range
            }
        }

        // Apply the difference array to the nums array using prefix sums
        int currentChange = 0;  // Tracks the cumulative change to be applied.
        for (int i = 0; i < n; i++) {
            currentChange += delta[i];  // Update cumulative change.
            nums[i] += currentChange;  // Apply the change to the nums array.
        }

        // Check if the resulting nums array consists of all zeroes
        for (int num : nums) {
            if (num > 0) {
                // If any number is positive, the array is not zeroed.
                return false;
            }
        }

        // If no positive numbers found, the array is zeroed.
        return true;
    }
}
