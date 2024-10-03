import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Approach:
    // 1. First, sort the intervals based on their start time.
    // 2. Initialize the start and end of the first interval.
    // 3. Iterate through the remaining intervals:
    //    - If the current interval overlaps with the previous one, update the end to the maximum of the two.
    //    - If it doesn't overlap, add the previous interval to the result list and update start and end to the current interval.
    // 4. Finally, add the last processed interval to the result list.
    // 5. Convert the result list to a 2D array and return it.

    // Time Complexity (TC): O(n log n)
    // The sorting step dominates the time complexity, where n is the number of intervals.
    // The iteration over the intervals takes O(n).

    // Space Complexity (SC): O(n)
    // We use O(n) space for the result list (ds), and no extra space other than that.

    public int[][] merge(int[][] intervals) {
        
        // Step 1: Sort the intervals by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // List to store the merged intervals
        List<int[]> ds = new ArrayList<>();
        
        // Number of intervals
        int n = intervals.length;

        // Initialize the start and end of the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Start iterating from the second interval
        int i = 1;

        while (i < n) {
            // If the current interval overlaps with the previous one
            if (end >= intervals[i][0]) {
                // Update the end to the maximum end time
                end = Math.max(intervals[i][1], end);
            } else {
                // If no overlap, add the previous interval to the list
                ds.add(new int[]{start, end});
                // Update start and end to the current interval
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }

        // Add the last interval
        ds.add(new int[]{start, end});

        // Convert the list to an array
        int[][] sol = new int[ds.size()][2];
        for (int it = 0; it < ds.size(); it++) {
            sol[it] = ds.get(it);
        }

        return sol;
    }
}
