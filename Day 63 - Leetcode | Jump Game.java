/**
 * Problem: Jump Game
 * Link: https://leetcode.com/problems/jump-game/
 *
 * The task is to determine if you can reach the last index of the array. 
 * Each element in the array represents the maximum number of steps you can jump from that position.
 *
 * Approach:
 * - **Step 1:** Initialize a variable `maxIndex` to keep track of the furthest position we can reach.
 * - **Step 2:** Iterate through the array. For each index `i`, check if it is reachable by comparing it with `maxIndex`.
 *     - If `i` is greater than `maxIndex`, it means we cannot reach that index, so return `false`.
 *     - Otherwise, update `maxIndex` to the maximum of its current value and `i + nums[i]`.
 * - **Step 3:** After the loop, if we have successfully traversed the array without returning `false`, return `true`.
 *
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(1), since no additional space is used.
 */

class Solution {
    
    // Function to check if you can jump to the last index.
    public boolean canJump(int[] nums) {
        int maxIndex = 0; // To track the farthest index that can be reached.
        int n = nums.length; // Length of the input array.
        
        // Iterate through the array.
        for (int i = 0; i < n; i++) {
            // If the current index `i` is greater than `maxIndex`, it means it is unreachable.
            if (i > maxIndex) {
                return false; // Return false because we can't jump to this index.
            }
            
            // Update `maxIndex` to the maximum of its current value and `i + nums[i]`.
            maxIndex = Math.max(i + nums[i], maxIndex);
        }
        
        // If we exit the loop, it means we can reach the last index, so return true.
        return true;
    }
}

/**
 * Example:
 * Input: nums = [2, 3, 1, 1, 4]
 * Output: true
 * Explanation:
 * - Start at index 0, we can jump to index 1 or index 2.
 * - From index 1, we can jump to the last index (index 4).
 * - Therefore, it's possible to reach the last index.
 * 
 * Example 2:
 * Input: nums = [3, 2, 1, 0, 4]
 * Output: false
 * Explanation:
 * - Start at index 0, we can jump to index 1, 2, or 3.
 * - However, at index 3, we can't jump to any further position, and the last index (index 4) is unreachable.
 */
