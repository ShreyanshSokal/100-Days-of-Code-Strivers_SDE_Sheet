/* Intuition and Approach

1. **Find the breaking point:** 
    - Traverse the array from right to left to find the first element that is smaller than the element next to it. This point is called the "breaking point".
    - If no such breaking point is found, it means the array is sorted in descending order. In this case, reverse the entire array to get the smallest permutation.

2. **Find the next greater element:**
    - Traverse the array again from right to left to find the first element that is greater than the element at the breaking point.

3. **Swap the breaking point element with the next greater element:**
    - Swap these two elements to form the next permutation.

4. **Reverse the elements after the breaking point:**
    - Reverse the elements to the right of the breaking point to get the next smallest lexicographical order.

*/

// Code

class Solution {
    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;
        
        // Step 1: Find the breaking point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // If no breaking point, reverse the entire array
        if (breakPoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the next greater element to swap with
        int nextGreaterElementIdx = -1;
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                nextGreaterElementIdx = i;
                break;
            }
        }

        // Step 3: Swap the breaking point element with the next greater element
        int temp = nums[breakPoint];
        nums[breakPoint] = nums[nextGreaterElementIdx];
        nums[nextGreaterElementIdx] = temp;

        // Step 4: Reverse the elements after the breaking point
        reverse(nums, breakPoint + 1, n - 1);
    }
}
