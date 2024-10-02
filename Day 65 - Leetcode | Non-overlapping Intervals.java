/**
 * Problem: Non-overlapping Intervals
 * Link: https://leetcode.com/problems/non-overlapping-intervals/
 *
 * The task is to remove the minimum number of intervals so that the remaining intervals are non-overlapping.
 *
 * Approach:
 * - **Step 1:** Treat this as an inverse of the "Maximum Number of Meetings in a Room" problem.
 *     - We want to find the maximum number of non-overlapping intervals and then remove the rest.
 * - **Step 2:** Sort intervals by their end time to prioritize finishing earlier intervals first.
 * - **Step 3:** Iterate through the sorted intervals and count the non-overlapping ones.
 *     - The intervals that cannot be added without overlapping are the ones to be removed.
 * 
 * Time Complexity: O(n log n) due to sorting.
 * Space Complexity: O(n) for storing interval data.
 */

class Solution {
    
    // Function to find the minimum number of overlapping intervals to remove.
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        // If there are no intervals, no need to remove any.
        if (n == 0) return 0;
        
        // Step 1: Sort the intervals by their end time to ensure we prioritize finishing early.
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // Step 2: Initialize the count for non-overlapping intervals and track the last end time.
        int count = 1; // Start by counting the first interval
        int lastEndTime = intervals[0][1]; // Track the end time of the last added interval
        
        // Step 3: Iterate through the sorted intervals.
        for (int i = 1; i < n; i++) {
            // If the start of the current interval is greater than or equal to the end of the last one, it's non-overlapping.
            if (intervals[i][0] >= lastEndTime) {
                count++; // Include this interval in the non-overlapping count
                lastEndTime = intervals[i][1]; // Update the end time of the last added interval
            }
        }
        
        // Step 4: Calculate the number of intervals to remove.
        // The number of intervals to remove is the total number of intervals minus the non-overlapping ones.
        return n - count;
    }
}

/**
 * Example:
 * Input: intervals = [[1,2], [2,3], [3,4], [1,3]]
 * Output: 1
 * Explanation:
 * - The intervals [1,3] and [1,2] overlap. By removing [1,3], the rest are non-overlapping.
 * 
 * Example 2:
 * Input: intervals = [[1,2], [1,2], [1,2]]
 * Output: 2
 * Explanation:
 * - All intervals overlap, so we must remove two of them to leave only one.
 */
