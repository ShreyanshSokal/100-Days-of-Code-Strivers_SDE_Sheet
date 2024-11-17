import java.util.Arrays;

class Solution {

    /**
     * Intuition:
     * - This problem involves finding pairs (i, j) such that:
     *   lower <= nums[i] + nums[j] <= upper, with i < j.
     * - By sorting the array, we can efficiently find the valid pairs using two pointers or binary search.
     * - For each element `nums[i]`, determine the range of indices `j` (i < j) 
     *   such that the sum lies within the given bounds.
     * - Use `lowerBound` and `upperBound` to determine the valid range for `j` in O(log n) time.
     * 
     * Time Complexity:
     * - Sorting: O(n log n)
     * - For each element, perform two binary searches: O(n * log n)
     * - Overall: O(n log n)
     * 
     * Space Complexity: O(1)
     * - The algorithm uses a constant amount of extra space.
     */

    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the array to enable binary search
        Arrays.sort(nums);
        long count = 0;

        // Iterate through each element to find valid pairs
        for (int i = 0; i < nums.length - 1; i++) {
            // Find the range of valid indices using binary search
            int low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            count += up - low;
        }
        return count;
    }

    /**
     * Finds the first index where the value is >= target.
     */
    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    /**
     * Finds the first index where the value is > target.
     */
    private int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
