class Solution {

    /**
     * Problem Description:
     * Given an array `nums` of `n` integers and an integer `target`, return all the quadruplets 
     * [nums[a], nums[b], nums[c], nums[d]] such that:
     * 1. 0 <= a, b, c, d < n
     * 2. a, b, c, and d are distinct.
     * 3. nums[a] + nums[b] + nums[c] + nums[d] == target
     * The solution set must not contain duplicate quadruplets.
     * 
     * Intuition:
     * The problem is an extension of the "3Sum" problem, where we need to find quadruplets in an array 
     * that sum up to a given target. A brute force approach would involve checking every possible quadruplet, 
     * but this would be inefficient with a time complexity of O(n^4). Instead, we can optimize this using 
     * sorting and a two-pointer technique after fixing two elements.
     * 
     * Approach:
     * 1. Sort the array to handle duplicates easily and to enable the two-pointer technique.
     * 2. Use two nested loops to fix the first two elements (`nums[i]` and `nums[j]`).
     *    - Skip duplicates for both elements by checking if `nums[i] == nums[i-1]` and `nums[j] == nums[j-1]`.
     * 3. Use two pointers, `k` (starting from `j+1`) and `l` (starting from the end of the array), 
     *    to find pairs that sum with `nums[i]` and `nums[j]` to the target value.
     *    - Adjust the pointers based on the sum:
     *        - If the sum is less than the target, move the `k` pointer rightward to increase the sum.
     *        - If the sum is greater than the target, move the `l` pointer leftward to decrease the sum.
     *        - If the sum equals the target, add the quadruplet to the solution and adjust both pointers 
     *          while skipping duplicates.
     * 
     * Time Complexity:
     * - The time complexity is O(n^3) because we have two nested loops and the two-pointer technique 
     *   runs in linear time for each iteration.
     * 
     * Space Complexity:
     * - The space complexity is O(n) for the space required by the sorting algorithm, but the solution 
     *   itself only uses a constant amount of extra space (O(1)).
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums); // Sort the array to enable two-pointer technique and handle duplicates
        List<List<Integer>> solution = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Skip duplicates for the first element of the quadruplet
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for the second element of the quadruplet
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1, l = n - 1; // Initialize two pointers for the remaining elements

                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];

                    if (sum < target) {
                        // Sum is too small, move the `k` pointer rightward
                        k++;
                    } else if (sum > target) {
                        // Sum is too large, move the `l` pointer leftward
                        l--;
                    } else {
                        // Found a valid quadruplet
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        Collections.sort(temp);

                        solution.add(temp);

                        // Move pointers and skip duplicates
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return solution;
    }
}
