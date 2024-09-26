/**
 * Problem: Minimum Bit Flips to Convert Number (EASY)
 * Link: [No specific link]
 *
 * The task is to determine the minimum number of bit flips required to convert the number `start` to `goal`.
 *
 * Approach:
 * - **Step 1:** Calculate the XOR of `start` and `goal`. XOR will give a result where bits differ between `start` and `goal`.
 * - **Step 2:** Count the number of 1's in the XOR result since each 1 represents a bit that needs to be flipped.
 * - **Step 3:** Return the total number of bit flips (i.e., the number of 1's in the XOR result).
 *
 * Time Complexity: O(log n), where `n` is the number of bits in the XOR result.
 * Space Complexity: O(1).
 */

class Solution {
    public int minBitFlips(int start, int goal) {
        // Step 1: XOR of start and goal to find differing bits.
        int xor = start ^ goal, count = 0;

        // Step 2: Count the number of 1's in the XOR result.
        while (xor > 0) {
            // Check if the last bit is 1 (indicating a bit flip needed).
            int temp = xor % 2;
            if (temp == 1) count++; // Increment count for each differing bit.
            xor = xor / 2; // Right shift to process the next bit.
        }

        // Step 3: Return the total number of bit flips.
        return count;
    }
}

/**
 * Example:
 * start = 10 (1010 in binary)
 * goal  =  7 (0111 in binary)
 * XOR = 10 ^ 7 = 1101 (binary)
 * The differing bits are 1, 1, 0, 1, so 3 bits need to be flipped.
 */
