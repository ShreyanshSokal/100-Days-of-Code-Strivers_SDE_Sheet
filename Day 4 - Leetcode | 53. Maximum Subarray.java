
/* Explanation of the Code

The problem can be solved using Kadane's Algorithm, which is a dynamic programming approach to find the maximum sum of a contiguous subarray in an array of integers.

1. **Initialization:**
    - We initialize two variables: `maxi` to store the maximum subarray sum, and `sum` to store the current subarray sum. `maxi` is initialized to the smallest possible integer value (`Integer.MIN_VALUE`) to ensure any sum encountered will be larger, and `sum` is initialized to 0.

2. **Iterate through the array:**
    - We iterate through each element in the array.
    - For each element, we add it to the `sum`.
    - If `sum` is greater than `maxi`, we update `maxi` with the value of `sum`.
    - If `sum` becomes negative, we reset `sum` to 0 because a negative sum would decrease the overall sum of any subsequent subarray.

3. **Return the maximum subarray sum:**
    - After iterating through the array, `maxi` will contain the maximum subarray sum.

*/
  
// Code

class Solution {
    public int maxSubArray(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for (int i : arr) {
            sum += i;

            if (sum > maxi) maxi = sum;

            if (sum < 0) sum = 0;
        }
        return maxi;
    }
}
