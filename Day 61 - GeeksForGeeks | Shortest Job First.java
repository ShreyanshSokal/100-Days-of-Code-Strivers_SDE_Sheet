/**
 * Problem: Average Waiting Time (EASY)
 * Link: [No specific link]
 *
 * The goal is to find the average waiting time for processes given their burst times (bt[]). 
 * The waiting time is the cumulative time a process has to wait before it starts executing.
 *
 * Approach:
 * - **Step 1:** Sort the burst time array (`bt[]`) so that the processes with the shortest burst time are scheduled first. This helps minimize the overall waiting time.
 * - **Step 2:** Use a loop to calculate the total waiting time. For each process, the waiting time is the sum of all the previous burst times.
 * - **Step 3:** The average waiting time is the total waiting time divided by the number of processes.
 *
 * Time Complexity: O(n log n) due to sorting.
 * Space Complexity: O(1), no extra space used beyond the input array.
 */

class Solution {
    static int solve(int[] bt) {
        // Step 1: Sort the burst time array to minimize waiting time.
        Arrays.sort(bt);
        
        // Step 2: Initialize variables to calculate total waiting time and sum.
        int totalWaitingTime = 0, sum = 0, avg = 0;
        
        // Step 3: Calculate the total waiting time for each process.
        for (int i : bt) {
            sum += totalWaitingTime;  // Accumulate the waiting time.
            totalWaitingTime += i;    // Update the waiting time for the next process.
        }
        
        // Step 4: Calculate the average waiting time.
        avg = sum / bt.length;  // Integer division to get the average waiting time.
        
        return avg;
    }
}

/**
 * Example:
 * Input: bt = [3, 6, 9]
 * Output: 6
 * Explanation:
 * - Sorted burst times: [3, 6, 9]
 * - Waiting time for process 1 (bt = 3) = 0 (since it's the first process).
 * - Waiting time for process 2 (bt = 6) = 3 (previous process' burst time).
 * - Waiting time for process 3 (bt = 9) = 3 + 6 = 9.
 * - Total waiting time = 0 + 3 + 9 = 12.
 * - Average waiting time = 12 / 3 = 4.
 */
