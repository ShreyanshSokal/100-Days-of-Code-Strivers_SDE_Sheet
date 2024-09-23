/**
 * Problem: Maximum Meetings in One Room (MEDIUM)
 * Link: [No specific link]
 * 
 * Given the start and end times of several meetings, the goal is to determine the maximum number of meetings that can be scheduled in one room such that no two meetings overlap.
 *
 * Approach:
 * - **Step 1:** Create a list of `Data` objects to store the start time, end time, and position of each meeting.
 * - **Step 2:** Sort the meetings based on their end times, as scheduling meetings that finish earlier allows for more meetings to be conducted.
 * - **Step 3:** Iterate through the sorted meetings and count how many meetings can be scheduled without overlapping.
 * 
 * Time Complexity: O(n log n) due to sorting, where `n` is the number of meetings.
 * Space Complexity: O(n), required for the `Data` array.
 */

class Data {
    // Custom class to store the start time, end time, and position of a meeting.
    int s = 0, e = 0, pos = 0;

    // Constructor to initialize start, end, and position.
    Data(int start, int end, int position) {
        s = start;
        e = end;
        pos = position;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // Step 1: Create an array of Data objects to store meeting details.
        Data[] data = new Data[n];
        for (int i = 0; i < n; i++) {
            // Use 1-based indexing for the position of each meeting.
            data[i] = new Data(start[i], end[i], i + 1);
        }
        
        // Step 2: Sort the meetings by their end times.
        Arrays.sort(data, (d1, d2) -> d1.e - d2.e);

        // Step 3: Initialize the count of meetings and track the end time of the last scheduled meeting.
        int count = 1, lasttime = data[0].e;

        // Step 4: Iterate through the sorted meetings and schedule non-overlapping ones.
        for (int i = 1; i < n; i++) {
            // If the start time of the current meeting is after the last scheduled meeting's end time, schedule it.
            if (lasttime < data[i].s) {
                count++;
                lasttime = data[i].e;  // Update the end time to the current meeting's end time.
            }
        }

        // Return the total number of non-overlapping meetings that can be scheduled.
        return count;
    }
}
