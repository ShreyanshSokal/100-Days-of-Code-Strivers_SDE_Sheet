/**
 * Problem: Jump Game II
 * Link: https://leetcode.com/problems/jump-game-ii/
 *
 * The task is to find the minimum number of jumps required to reach the last index from the first index.
 * Each element in the array represents the maximum number of steps you can jump from that position.
 *
 * Approach:
 * - **Step 1:** Initialize two pointers `l` and `r`, representing the current window of positions we can jump from.
 * - **Step 2:** At each step, find the farthest position we can reach from the current window (from `l` to `r`).
 *     - Update the left pointer `l` to `r + 1`, and the right pointer `r` to the farthest position found.
 *     - Increment the jump counter.
 * - **Step 3:** Continue this process until we reach or exceed the last index.
 *
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(1), since no additional space is used.
 */

class Solution {
    
    // Function to find the minimum number of jumps to reach the last index.
    public int jump(int[] nums) {
        int n = nums.length;
        
        // If there's only one element or no need to jump, return 0.
        if (n <= 1) return 0;
        
        int jump = 0;  // To count the number of jumps.
        int l = 0, r = 0;  // `l` and `r` represent the current window of reachable indices.
        
        // Continue until we can reach or exceed the last index.
        while (r < n - 1) {
            int farthest = 0;  // To track the farthest position we can reach.
            
            // Explore the current window of indices (from `l` to `r`).
            for (int i = l; i <= r; i++) {
                // Update the farthest position that can be reached.
                farthest = Math.max(farthest, i + nums[i]);
            }
            
            // Move the window to the next set of reachable indices.
            l = r + 1;
            r = farthest;
            
            // Increment the jump count.
            jump++;
        }
        
        // Return the total number of jumps required.
        return jump;
    }
}

/**
 * Example:
 * Input: nums = [2, 3, 1, 1, 4]
 * Output: 2
 * Explanation:
 * - Jump 1: Move from index 0 to index 1 (jump size = 3).
 * - Jump 2: Move from index 1 to the last index (jump size = 4).
 * 
 * Example 2:
 * Input: nums = [2, 3, 0, 1, 4]
 * Output: 2
 * Explanation:
 * - Jump 1: Move from index 0 to index 1.
 * - Jump 2: Move from index 1 to the last index.
 */
