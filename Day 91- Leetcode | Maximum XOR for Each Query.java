import java.util.Arrays;

class Solution {

    // Function to calculate maximum XOR for each prefix using bit manipulation.

    // Parameters:
    // - nums: Array of integers.
    // - maximumBit: Number of bits allowed for XOR.
    
    // Time Complexity (TC): O(n)
    // - The optimized solution completes in linear time by iterating through `nums` once to calculate the group XOR and another loop to fill `sol`.

    // Space Complexity (SC): O(n)
    // - The result array `sol` has size n.

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int groupxor = 0;   // To store XOR of all elements in nums.
        int n = nums.length;
        int k = (int) Math.pow(2, maximumBit);  // Calculate 2^maximumBit (the maximum value for k).

        // Calculate the XOR of the entire array.
        for (int i = 0; i < n; i++) {
            if (i == 0) groupxor = nums[i];
            else groupxor ^= nums[i];
        }

        int[] sol = new int[n];

        // Calculate the XOR for each prefix in reverse order
        // and update groupxor to exclude elements from the end of `nums`.
        for (int i = 0; i < n; i++) {
            sol[i] = groupxor;
            groupxor ^= nums[n - i - 1];
        }

        // BRUTE FORCE (Commented out):
        // - For each prefix result, calculate all possible XOR values up to k.
        // - Check each XOR result to find the maximum XOR.

        // for (int i = 0; i < n; i++) {
        //     int cur = sol[i], max = -1, maxK = -1;
        //     for (int j = 0; j < k; j++) {
        //         int temp = j ^ sol[i];
        //         if (temp > max) {
        //             max = temp;
        //             maxK = j;
        //         }
        //     }
        //     sol[i] = maxK; // Set the solution to the value producing max XOR.
        // }

        // OPTIMIZED SOLUTION:
        // Instead of brute-force search, use `k - 1` to get the maximum XOR for each prefix.
        for (int i = 0; i < n; i++) {
            sol[i] = sol[i] ^ (k - 1);  // XOR with k-1 to flip bits within the allowed bit range.
        }

        return sol;
    }
}
