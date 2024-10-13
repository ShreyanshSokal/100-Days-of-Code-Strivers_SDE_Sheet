class Solution {

    // Approach:
    // 1. First, add all the intervals that come before the new interval without any overlap.
    // 2. Then, merge the new interval with the intervals that overlap by updating the start and end boundaries.
    // 3. After merging, add the merged interval.
    // 4. Finally, add all the intervals that come after the merged interval.
    // 5. Convert the list to a 2D array and return the result.

    // Time Complexity (TC): O(n)
    // We iterate through the intervals array once, where n is the number of intervals.

    // Space Complexity (SC): O(n)
    // We are using a list to store the intervals, and in the worst case, we store all intervals in it, so the space complexity is O(n).

    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> ds = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Step 1: Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            ds.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        int start = newInterval[0], end = newInterval[1];

        while (i < n && end >= intervals[i][0]) {
            start = Math.min(intervals[i][0], start);  // Update the start of the merged interval
            end = Math.max(intervals[i][1], end);      // Update the end of the merged interval
            i++;
        }

        // Step 3: Add the merged interval
        ds.add(new int[]{start, end});

        // Step 4: Add remaining intervals after the new merged interval
        while (i < n) {
            ds.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        // Step 5: Convert the list to a 2D array
        int[][] ans = new int[ds.size()][2];

        for (int j = 0; j < ds.size(); j++) {
            ans[j] = ds.get(j);
        }

        return ans;
    }
}
