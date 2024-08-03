class Solution {
    /**
     * Problem Description:
     * You are given an array `nums` containing `n` elements, where one element 
     * appears more than `n/2` times. This element is known as the majority element. 
     * The task is to find and return this majority element.
     * 
     * Intuition:
     * The problem can be solved efficiently using the **Boyer-Moore Voting Algorithm**. 
     * The intuition behind this algorithm is to maintain a candidate element and a count. 
     * The count increases when the current element is the same as the candidate and 
     * decreases otherwise. If the count reaches zero, we update the candidate to the 
     * current element. The majority element is guaranteed to be the candidate at the 
     * end of this process because it appears more than `n/2` times.
     * 
     * Approach:
     * 1. Initialize `element` with -1 and `count` with 0.
     * 2. Iterate through the array:
     *    - If `count` is 0, update `element` to the current element.
     *    - If the current element matches `element`, increment `count`.
     *    - If the current element does not match `element`, decrement `count`.
     * 3. By the end of the iteration, `element` will hold the majority element.
     * 
     * Time Complexity:
     * - The time complexity is O(n) because the algorithm makes a single pass through 
     *   the array.
     * 
     * Space Complexity:
     * - The space complexity is O(1) as the algorithm only uses a constant amount of extra space.
     */
    
    public int majorityElement(int[] nums) {
        int element = -1; // Candidate for the majority element
        int count = 0;    // Counter for the candidate element

        for(int i = 0; i < nums.length; i++) {
            // If the count is zero, update the candidate element
            if(count == 0) 
                element = nums[i];
            
            // If the current element matches the candidate, increment the count
            if(nums[i] == element)
                count++;
            else
                count--; // Otherwise, decrement the count
        }

        // At the end, 'element' will be the majority element
        return element;
    }
}


//This code implements the **Boyer-Moore Voting Algorithm** to efficiently find the majority element in a single pass through the array. 
//The approach is both time and space efficient, making it suitable for large datasets.
