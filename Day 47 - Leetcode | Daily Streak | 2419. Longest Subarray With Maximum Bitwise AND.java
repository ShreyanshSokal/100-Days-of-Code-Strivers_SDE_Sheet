/**
 * Problem: Longest Subarray of 1's After Deleting One Element (LeetCode)
 * Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/ (MEDIUM)
 *
 * The solution finds the longest subarray where the maximum AND operation results in the maximum value within the array.
 * This problem can be interpreted as finding the maximum length subarray containing only the maximum element.
 *
 * Approach:
 * - **Step 1:** Find the maximum element in the array by iterating through all elements.
 * - **Step 2:** Traverse the array to find the longest contiguous subarray that contains only the maximum element.
 * - Update the maximum length as we find subarrays, and reset the count whenever a non-maximum element is encountered.
 *
 * Time Complexity: O(n) [Single pass to find max, another pass to calculate the length of the longest subarray]
 * Space Complexity: O(1) [Constant space used]
 */

class Solution {

    // Function to find the length of the longest subarray consisting of the maximum element.
    public int longestSubarray(int[] nums) {
        
        // Step 1: Find the maximum value in the array.
        int n = nums.length, max = 0;

        for (int i : nums) {
            max = Math.max(i, max);  // Update max if a larger value is found.
        }

        // Step 2: Traverse the array and calculate the longest subarray containing the max value.
        int count = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            // If the current element equals the maximum value, increase the count.
            if (nums[i] == max) {
                count++;
            } else {
                // Update the maximum length and reset count when a non-max element is encountered.
                maxLength = Math.max(count, maxLength);
                count = 0;
            }
        }

        // Final update for the max length if the last subarray contains max elements.
        if (count > 0) maxLength = Math.max(count, maxLength);

        // Return the length of the longest subarray with maximum elements.
        return maxLength;
    }
}
