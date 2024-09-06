/**
 * Problem: Trapping Rain Water (LeetCode)
 * Link: https://leetcode.com/problems/trapping-rain-water/ (HARD)
 *
 * This solution efficiently calculates the total amount of trapped water between the bars of varying heights.
 *
 * Approach:
 * - Use a two-pointer approach starting from both ends of the array (left = 0, right = n - 1).
 * - Move towards the center based on the smaller of the two values at `left` and `right` to ensure that we always
 *   have at least one guaranteed "smaller max" value for calculating the trapped water.
 * - Keep track of `leftmax` and `rightmax`, the maximum values encountered on the left and right sides.
 * - For each element, calculate the trapped water as the difference between the current max (either left or right)
 *   and the current height.
 * - If both `left` and `right` are equal, move any one pointer (typically `left`).
 * - Sum the total trapped water and return it.
 *
 * Time Complexity: O(n) [Single pass with two pointers]
 * Space Complexity: O(1)
 */

class Solution {

    public int trap(int[] height) {
        // Initialize variables for left and right pointers, max values, and total water trapped.
        int leftmax = 0, rightmax = 0, total = 0, left = 0, right = height.length - 1;

        // Two-pointer approach to move from both ends towards the center.
        while (left < right) {
            // If the height on the left side is smaller or equal to the right side.
            if (height[left] <= height[right]) {
                // If the left max is greater than the current height, add the difference to total.
                if (leftmax > height[left]) {
                    total += leftmax - height[left];
                } else {
                    // Otherwise, update leftmax.
                    leftmax = height[left];
                }
                left++;  // Move left pointer.
            } else {
                // If the right max is greater than the current height, add the difference to total.
                if (rightmax > height[right]) {
                    total += rightmax - height[right];
                } else {
                    // Otherwise, update rightmax.
                    rightmax = height[right];
                }
                right--;  // Move right pointer.
            }
        }

        // Return the total amount of trapped water.
        return total;
    }
}
