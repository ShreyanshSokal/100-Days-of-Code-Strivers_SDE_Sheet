import java.util.List;
import java.util.ArrayList;

class Solution {

    // BRUTE FORCE APPROACH:
    // - Use recursion to check all possible combinations of numbers.
    // - For each combination, calculate the bitwise AND of the chosen elements.
    // - Track the largest combination where the bitwise AND result reaches zero.

    // Parameters:
    // - i: Current index in nums array.
    // - nums: Array of candidates for combination.
    // - size: Size of the current combination.
    // - bitwiseAnd: Bitwise AND of the current combination.
    // - n: Total number of elements in nums array.

    // Time Complexity (TC) for Brute Force: O(2^n)
    // As it explores all subsets of nums array, this approach has exponential complexity.

    // Space Complexity (SC) for Brute Force: O(n)
    // Space for recursive stack and combination list `ds`.

    List<Integer> ds = new ArrayList<>();
    
    int largestCombination(int i, int[] nums, int size, int bitwiseAnd, int n) {
        if (i == n || bitwiseAnd == 0) {
            return bitwiseAnd == 0 ? size - 1 : size; // If bitwise AND reaches zero, return size - 1.
        }

        // Pick the current number and include in combination
        ds.add(nums[i]);
        int pick = largestCombination(i + 1, nums, size + 1, (bitwiseAnd & nums[i]), n);
        ds.remove(ds.size() - 1);

        // Do not pick the current number
        int notpick = largestCombination(i + 1, nums, size, bitwiseAnd, n);

        return Math.max(pick, notpick);
    }

    // OPTIMIZED APPROACH:
    // - Count bits at each position across all numbers to find the highest combination size.
    // - Check each bit position from the most significant bit downwards.
    // - For each position, count how many numbers have the bit set to 1.
    // - Track the maximum count, as it gives the largest combination with a non-zero AND.

    // Time Complexity (TC): O(m * n)
    // m: Number of bits in the maximum number in candidates.
    // n: Length of candidates array.

    // Space Complexity (SC): O(1)
    // Only uses a few variables for tracking bit positions and counts.

    public int largestCombination(int[] candidates) {
        // Step 1: Find the highest number in `candidates` to determine the bit length.
        int max = 0;
        for (int i : candidates) max = Math.max(i, max);

        // Step 2: Calculate the bit length of the highest number.
        int temp = max;
        int maxBitPosition = 1;
        while (temp > 0) {
            temp >>= 1;
            maxBitPosition++;
        }

        // Step 3: Count how many numbers have each bit set, and track the highest count.
        int maxcount = 0;
        for (int i = maxBitPosition; i > 0; i--) {
            int count = 0;
            for (int j = 0; j < candidates.length; j++) {
                if ((candidates[j] & (1 << (i - 1))) > 0) {  // Check if the i-th bit is set
                    count++;
                }
            }
            maxcount = Math.max(maxcount, count);
        }

        return maxcount;
    }
}
