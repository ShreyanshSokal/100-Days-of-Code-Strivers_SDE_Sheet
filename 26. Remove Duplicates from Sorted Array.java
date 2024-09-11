/**
 * Problem: Remove Duplicates from Sorted Array (LeetCode)
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/ (EASY)
 *
 * This solution removes duplicates in-place from a sorted array and returns the new length of the array.
 * The array is modified such that each unique element appears only once, and the remaining elements 
 * (after the new length) are irrelevant.
 *
 * Approach:
 * - Initialize an `iter` pointer starting at 1 and a `prev` variable as the first element of the array.
 * - Iterate through the array starting from index 1.
 * - If the current element is not the same as the previous element (`prev`), place the current element
 *   at the `iter` index and move the `iter` pointer forward.
 * - Update `prev` to the current element, ensuring that each unique element is stored at the front of the array.
 * - Return `iter` as the new length of the array without duplicates.
 *
 * Time Complexity: O(n) [Single pass through the array]
 * Space Complexity: O(1) [In-place modification of the array]
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        
        // Get the length of the array and initialize pointers.
        int n = nums.length, iter = 1, prev = nums[0];

        // Traverse the array starting from the second element.
        for (int i = 1; i < n; i++) {
            // If the current element is different from the previous unique element.
            if (nums[i] != prev) {
                // Place the unique element at the `iter` position and move `iter` forward.
                nums[iter] = nums[i];
                // Update `prev` to the current element.
                prev = nums[i];
                iter++;
            }
        }
        // Return the new length of the array with unique elements.
        return iter;
    }
}
