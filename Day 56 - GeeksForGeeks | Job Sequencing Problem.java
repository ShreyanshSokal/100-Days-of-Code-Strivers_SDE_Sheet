/**
 * Problem: Job Sequencing Problem (Job Scheduling to Maximize Profit)
 * Link: [No specific link] (MEDIUM)
 *
 * Given a set of jobs with deadlines and profits, the goal is to maximize the profit by scheduling as many jobs as possible before their deadlines.
 *
 * Approach:
 * - **Step 1:** Identify the maximum deadline from the jobs, as we only need to consider slots up to this deadline.
 * - **Step 2:** Sort the jobs in descending order of profit to prioritize higher-profit jobs.
 * - **Step 3:** Attempt to schedule each job at its latest available slot before the deadline. If the slot is occupied, check for an earlier available slot.
 * - **Step 4:** After all jobs are scheduled, calculate the total profit and the number of jobs successfully scheduled.
 *
 * Time Complexity: O(n log n + n * d), where n is the number of jobs, and d is the maximum deadline.
 * Space Complexity: O(d), where d is the maximum deadline (to track scheduled slots).
 */

class Solution {

    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        
        // Step 1: Find the maximum deadline among the jobs.
        int maxDeadline = 0;
        for (Job i : arr) {
            maxDeadline = Math.max(maxDeadline, i.deadline);
        }
        
        // Step 2: Create an array to keep track of scheduled jobs based on deadlines.
        int[] sol = new int[maxDeadline + 1]; // sol[i] will store the profit of the job scheduled at slot i.
        
        // Step 3: Sort the jobs in descending order of profit.
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);
        
        // Step 4: Iterate over all jobs and schedule them in the latest available slot before their deadline.
        for (int i = 0; i < n; i++) {
            Job job = arr[i];
            
            // If the slot for the job's deadline is available, schedule it.
            if (sol[job.deadline] == 0) {
                sol[job.deadline] = job.profit;
            } else {
                // If the slot is taken, try earlier slots before the job's deadline.
                int iter = job.deadline - 1;
                while (iter >= 1) {
                    if (sol[iter] == 0) {
                        sol[iter] = job.profit;
                        break;
                    }
                    iter--;
                }
            }
        }
        
        // Step 5: Calculate the total profit and the number of jobs successfully scheduled.
        int maxProfit = 0, maxJobs = 0;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] == 0) continue;  // Skip empty slots.
            maxProfit += sol[i];  // Add the profit from the scheduled job.
            maxJobs++;            // Count the job.
        }
        
        // Return the total number of jobs scheduled and the maximum profit earned.
        return new int[] {maxJobs, maxProfit};
    }
}

/*
 * Class representing a Job with an ID, deadline, and profit.
 * class Job {
 *     int id, profit, deadline;
 *     Job(int x, int y, int z){
 *         this.id = x;
 *         this.deadline = y;
 *         this.profit = z; 
 *     }
 * }
 */
