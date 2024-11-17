/**
 * Intuition:
 * - In a sorted array where every element appears twice except one, the unique element can be found using binary search.
 * - Key observations:
 *   1. If `nums[mid] == nums[mid+1]` and `mid` is even, the single element is on the right; otherwise, it's on the left.
 *   2. If `nums[mid] == nums[mid-1]` and `mid` is odd, the single element is on the right; otherwise, it's on the left.
 *   3. If `nums[mid]` is not equal to either `nums[mid-1]` or `nums[mid+1]`, `nums[mid]` is the unique element.
 * - The search is narrowed down based on these conditions using binary search.
 * 
 * Time Complexity:
 * - O(log n): Binary search divides the search space by half in each iteration.
 * 
 * Space Complexity:
 * - O(1): No additional space is used.
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 1, high = n - 2;

        // Edge cases: Single element is at the beginning or end
        if (n == 1) return nums[0];
        if (nums[1] != nums[0]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        // Binary search for the single non-duplicate element
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if the current element is the single one
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];

            // Determine the search direction
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        return -1; // This line should never be reached
    }
}
