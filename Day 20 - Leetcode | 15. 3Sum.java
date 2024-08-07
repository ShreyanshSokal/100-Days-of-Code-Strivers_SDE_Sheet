class Solution {

    /**
     * Problem Description:
     * Given an integer array `nums`, return all the triplets [nums[i], nums[j], nums[k]] such 
     * that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. The solution set 
     * must not contain duplicate triplets.
     * 
     * Intuition:
     * The problem is a classic example of the "3Sum" problem, where we need to find triplets 
     * in an array that sum up to zero. A brute force approach would involve checking every 
     * possible triplet, but this would be inefficient with a time complexity of O(n^3). 
     * Instead, we can optimize this using sorting and a two-pointer approach.
     * 
     * Approach:
     * 1. Sort the array to enable the two-pointer technique and make it easier to handle duplicates.
     * 2. Iterate through the array with a variable `i` representing the first element of the triplet.
     *    - Skip duplicates for the first element by checking if `nums[i] == nums[i-1]`.
     *    - Use two pointers, `j` (starting from `i+1`) and `k` (starting from the end of the array), 
     *      to find pairs that sum up with `nums[i]` to zero.
     *    - Adjust the pointers based on the sum:
     *        - If the sum is greater than zero, move the `k` pointer leftward to decrease the sum.
     *        - If the sum is less than zero, move the `j` pointer rightward to increase the sum.
     *        - If the sum equals zero, add the triplet to the solution and adjust both pointers 
     *          while skipping duplicates.
     * 
     * Time Complexity:
     * - The time complexity is O(n^2) because we sort the array first and then use two nested loops 
     *   where the inner loop uses the two-pointer technique.
     * 
     * Space Complexity:
     * - The space complexity is O(n) for the space required by the sorting algorithm, but the 
     *   solution itself only uses a constant amount of extra space (O(1)).
     */

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> solution = new ArrayList<>();

        // Sort the array to apply two-pointer technique
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            // Skip duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            // Use two pointers to find pairs that sum with nums[i] to zero
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    // Sum is too large, move the `k` pointer leftward
                    k--;
                } else if (sum < 0) {
                    // Sum is too small, move the `j` pointer rightward
                    j++;
                } else {
                    // Found a valid triplet
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    solution.add(temp);

                    // Move pointers and skip duplicates
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return solution;
    }
}
