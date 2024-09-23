/**
 * Problem: Minimum Platforms (MEDIUM)
 * Link: [No specific link]
 *
 * Given arrival and departure times of trains, the task is to find the minimum number of platforms required at the railway station such that no train has to wait.
 *
 * Approach:
 * - **Step 1:** Sort the arrival and departure arrays. Sorting helps to process the trains in the order of their arrivals and departures.
 * - **Step 2:** Use two pointers to traverse the sorted arrival and departure arrays. Keep track of how many platforms are needed at each moment by comparing arrivals and departures.
 * - **Step 3:** If a train arrives before another departs, increment the platform count. If a train departs before the next one arrives, decrement the platform count.
 * - **Step 4:** Track the maximum platform count at any point, which will be the result.
 *
 * Time Complexity: O(n log n) due to sorting, where `n` is the number of trains.
 * Space Complexity: O(1) (excluding input arrays).
 */

class Solution {
    // Function to find the minimum number of platforms required at the railway station.
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;  // Number of trains

        // Step 1: Sort the arrival and departure arrays.
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Step 2: Initialize two pointers for traversing the arrival and departure arrays.
        int i = 0, j = 0;

        // Step 3: Initialize variables to track the current number of platforms needed and the maximum platforms required.
        int cnt = 0, max = 0;

        // Step 4: Traverse through both arrays using the two pointers.
        while (i < n) {
            // If the next train arrives before the earliest departing train, a new platform is needed.
            if (arr[i] <= dep[j]) {
                cnt++;  // Increment platform count.
                i++;    // Move to the next arrival.
            } 
            // If a train departs before the next one arrives, free up a platform.
            else {
                cnt--;  // Decrement platform count.
                j++;    // Move to the next departure.
            }
            
            // Update the maximum number of platforms required.
            max = Math.max(cnt, max);
        }

        // Return the maximum number of platforms needed at any time.
        return max;
    }
}
