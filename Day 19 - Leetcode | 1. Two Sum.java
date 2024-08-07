class Solution {

    /**
     * Problem Description:
     * Given an array of integers `nums` and an integer `target`, return the indices of the 
     * two numbers such that they add up to the target. You may assume that each input would 
     * have exactly one solution, and you may not use the same element twice.
     * 
     * Intuition:
     * A brute-force approach would involve checking all pairs of elements to find the ones 
     * that sum up to the target, but this would be inefficient. Instead, we can use a hash 
     * map to store the numbers and their indices as we iterate through the array. By doing so, 
     * we can efficiently check if the complement of the current number (i.e., `target - nums[i]`) 
     * exists in the map, and if it does, we have found our solution.
     * 
     * Approach:
     * 1. Initialize a hash map to store the value and its index as we iterate through the array.
     * 2. For each element `nums[i]`:
     *    - Calculate the complement, which is `target - nums[i]`.
     *    - Check if the complement exists in the map.
     *    - If it does, return the indices of the current element and the complement.
     *    - Otherwise, add the current element and its index to the map.
     * 3. The solution is guaranteed to exist, so the function will always return within the loop.
     * 
     * Time Complexity:
     * - The time complexity is O(n) because we only traverse the array once, and hash map 
     *   operations (insert and lookup) are O(1) on average.
     * 
     * Space Complexity:
     * - The space complexity is O(n) for storing the elements in the hash map.
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(remaining)) {
                // Return the indices of the current element and the complement
                int[] ans = new int[]{i, map.get(remaining)};
                Arrays.sort(ans); // Ensure the smaller index comes first
                return ans;
            }

            // Add the current element and its index to the map
            map.put(nums[i], i);
        }

        // Return default value (not expected to reach here as the problem guarantees a solution)
        return new int[]{0, 0};
    }
}
