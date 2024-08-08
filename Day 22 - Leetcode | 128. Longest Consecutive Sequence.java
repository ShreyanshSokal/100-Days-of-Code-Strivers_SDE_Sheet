
class Solution {
    //Brute Force
    // public int longestConsecutive(int[] nums) {
        
    //     //Sort array and then check if next = i+1 ? count 

    //     int max = 1, n = nums.length, count = 1;
    //     if(n == 0)return 0;

    //     Arrays.sort(nums);
    //     //0 0 1 2 3 4 5 6 7 8
    //     for(int i=1 ;i< n; i++)
    //     {
    //         if(nums[i] == nums[i-1])continue;

    //         if(nums[i] == nums[i-1] + 1)count++;
    //         else
    //         {
    //             max = count > max? count : max;
    //             count = 1;
    //         }
    //     }
    //     max = count > max? count : max;
    //     return max;
    // }

    //Optimised
    public int longestConsecutive(int[] nums) {
        int max = 1, n = nums.length;
        if(n == 0)return 0;

        Set<Integer> lookup = new HashSet<>();
        for(int i: nums) lookup.add(i);

        for(int i : nums)
        {
            //lookup for a smaller value,
            // if it exists? drop this element

            //else this element is the starting point, 
            //now lookup for the next elements in array.
            int count = 0;

            if(lookup.contains(i-1) == true)continue; // not the first element

            else // first element of series
            {
                while(lookup.contains(i))
                {
                    count++;
                    i++;
                }
                max = count > max? count : max;
            }
        }
        return max;
    }
}

/**
 * Problem Description:
 * Given an unsorted array of integers `nums`, find the length of the longest consecutive elements sequence.
 * The sequence must be consecutive numbers and the solution must run in O(n) time complexity.
 * 
 * Intuition:
 * The problem asks for the longest sequence of consecutive numbers in an unsorted array.
 * A brute-force approach would involve sorting the array and then finding the longest sequence, but this would take O(n log n) time.
 * Instead, we can achieve an O(n) solution using a HashSet to track the elements and efficiently check for consecutive sequences.
 * 
 * Approach:
 * 1. Use a HashSet to store all elements of the array. This allows for O(1) average-time complexity when checking if an element exists in the set.
 * 2. Iterate through the array:
 *    - For each element, check if it is the start of a sequence (i.e., check if `nums[i] - 1` does not exist in the set).
 *    - If it is the start of a sequence, count the length of this sequence by checking consecutive elements (`nums[i] + 1`, `nums[i] + 2`, etc.).
 *    - Update the maximum length if the current sequence is longer.
 * 3. If an element is not the start of a sequence, it can be skipped because it will be part of a sequence starting with a smaller number.
 * 
 * Time Complexity:
 * - The time complexity is O(n) because each element is processed at most twice (once during the initial add to the set and once during the sequence check).
 * 
 * Space Complexity:
 * - The space complexity is O(n) for storing elements in the HashSet.
 */
