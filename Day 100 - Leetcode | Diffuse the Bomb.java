/**
 * Intuition:
 * - The problem involves creating a new array where each element is the sum of `k` consecutive elements
 *   either before or after the current index in a circular manner.
 * - Use modular arithmetic to handle the circular indexing effectively.
 * - Handle two cases:
 *   1. Positive `k`: Sum the next `k` elements clockwise.
 *   2. Negative `k`: Sum the previous `|k|` elements counterclockwise.
 * 
 * Time Complexity:
 * - O(n * |k|): For each of the `n` elements in the array, calculate the sum of `|k|` elements.
 * 
 * Space Complexity:
 * - O(n): The result array requires additional space of the same size as the input array.
 */

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        // If k is 0, all elements in the result array are 0
        if (k == 0) return result;

        // Calculate the sum for each element in the circular array
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Sum the next k elements
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // Sum the previous |k| elements
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }
            result[i] = sum;
        }

        return result;
    }
}
