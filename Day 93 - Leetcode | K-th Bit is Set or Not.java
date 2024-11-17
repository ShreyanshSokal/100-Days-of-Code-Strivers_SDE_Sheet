/**
 * Intuition:
 * - The task is to check if the K-th bit (0-based index) of a given integer `n` is set (1).
 * - We right-shift the number `n` by `k` positions to bring the K-th bit to the least significant position.
 * - After shifting, we use a bitwise AND operation with 1 to check if the K-th bit is set.
 * - If the result is 1, the bit is set; otherwise, it is not.
 * 
 * Time Complexity:
 * - O(k): The number is right-shifted `k` times.
 * 
 * Space Complexity:
 * - O(1): No additional space is used.
 */

class CheckBit {
    // Function to check if K-th bit is set or not
    static boolean checkKthBit(int n, int k) {
        // Right-shift `n` by `k` positions
        while (k > 0) {
            n = n >> 1;
            k--;
        }

        // Check if the least significant bit is 1
        if ((n & 1) == 1) return true;

        return false;
    }
}
