class Solution {
    /**
     * Problem Description:
     * You are given an integer array `nums`, and you need to find all the elements 
     * that appear more than `n/3` times. Note that there can be at most 2 such 
     * elements in the array.
     * 
     * Intuition:
     * The problem can be solved efficiently using a variation of the **Boyer-Moore Voting Algorithm**.
     * The key observation is that there can be at most 2 elements in the array that 
     * have a frequency greater than `n/3`. Therefore, we maintain two potential candidates 
     * and their counts, and iterate through the array to determine these candidates.
     * After identifying the potential candidates, we perform a final pass through the 
     * array to verify if these candidates actually appear more than `n/3` times.
     * 
     * Approach:
     * 1. Initialize two counters (`count1` and `count2`) and two candidate elements 
     *    (`el1` and `el2`).
     * 2. Iterate through the array:
     *    - If `count1` is 0 and the current element is not `el2`, set `el1` to the current element and set `count1` to 1.
     *    - If `count2` is 0 and the current element is not `el1`, set `el2` to the current element and set `count2` to 1.
     *    - If the current element matches `el1`, increment `count1`.
     *    - If the current element matches `el2`, increment `count2`.
     *    - If the current element matches neither, decrement both `count1` and `count2`.
     * 3. After processing all elements, manually check the actual count of `el1` and `el2` 
     *    in the array to ensure they appear more than `n/3` times.
     * 4. Add the verified elements to the result list and return it.
     * 
     * Time Complexity:
     * - The time complexity is O(n) because the algorithm makes two passes through 
     *   the array: one to find the potential candidates and another to verify them.
     * 
     * Space Complexity:
     * - The space complexity is O(1) as the algorithm uses a constant amount of extra space.
     */
    
    public List<Integer> majorityElement(int[] nums) {
        // At max there could be 2 elements for count > n/3
        int count1 = 0, count2 = 0;
        int el1 = -1, el2 = -1;
        int n = nums.length;

        // First pass to find potential candidates
        for(int i = 0; i < n; i++) {
            if(count1 == 0 && nums[i] != el2) {
                count1 = 1;
                el1 = nums[i];
            } else if(count2 == 0 && nums[i] != el1) {
                count2 = 1;
                el2 = nums[i];
            } else if(el1 == nums[i]) {
                count1++;
            } else if(el2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Manual check for both elements to confirm they appear more than n/3 times
        count1 = 0;
        count2 = 0;

        for(int i : nums) {
            if(i == el1) count1++;
            else if(i == el2) count2++;
        }

        List<Integer> list = new ArrayList<>();

        if(count1 > n / 3) list.add(el1);
        if(count2 > n / 3) list.add(el2);

        // Return the list containing elements that appear more than n/3 times
        return list;
    }
}

//This implementation uses a modified **Boyer-Moore Voting Algorithm** to efficiently find elements in the array that appear more than `n/3` times. 
//The algorithm first identifies up to two potential candidates and then verifies their actual counts in a second pass. 
//This approach ensures optimal performance with linear time complexity and constant space complexity.
