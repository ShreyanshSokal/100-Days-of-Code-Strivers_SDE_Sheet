/*

Intuition and Approach
Problem: Given a collection of intervals, merge all overlapping intervals.

Intuition:
The key insight is to sort the intervals by their start time. Once sorted, overlapping intervals will appear consecutively. By iterating through the sorted intervals and merging when necessary, we can effectively condense the list of intervals.

*/


class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];    
        });

        int n=intervals.length, m=intervals[0].length;

        List<int[]> ds = new ArrayList<>();
        
        ds.add(intervals[0]);
        
        for(int[] a:intervals )
        {
            int start = a[0];
            int end = a[1];

            int[] cur = ds.get(ds.size()-1);

            if( start <= cur[1] )
            {
                cur[1] = Math.max(cur[1], end);
            }
            else
            {
                ds.add(new int[]{start,end});
            }
        }

        int[][] sol = new int[ds.size()][2];

        int iter = 0;
        for(int[] i : ds)
        {
            sol[iter++] = i;
        }

        return sol;
    }
}
