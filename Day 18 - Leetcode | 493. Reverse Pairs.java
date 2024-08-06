class Solution {

    /**
     * Problem Description:
     * Given an array of integers `nums`, you need to find the number of reverse pairs. 
     * A reverse pair is defined as a pair (i, j) where 0 <= i < j < nums.length and 
     * nums[i] > 2 * nums[j].
     * 
     * Intuition:
     * A brute-force approach would involve checking all pairs (i, j) to count the reverse 
     * pairs, but this would be inefficient for large arrays. Instead, a more efficient 
     * approach can be implemented using the merge sort algorithm. During the merge step, 
     * while merging two sorted subarrays, we can count the reverse pairs.
     * 
     * Approach:
     * 1. Use a modified merge sort algorithm:
     *    - Divide the array into two halves.
     *    - Recursively sort each half.
     *    - During the merge step, count the reverse pairs by comparing elements from the 
     *      two halves.
     * 2. The function `countInversions` is used to count the reverse pairs during the merge step:
     *    - Iterate through the left subarray and count how many elements in the right subarray 
     *      satisfy the condition `nums[i] > 2 * nums[j]`.
     * 3. The `merge` function merges the two sorted subarrays into one sorted array.
     * 
     * Time Complexity:
     * - The time complexity is O(n log n) due to the merge sort algorithm, which is much 
     *   more efficient than the brute-force O(n^2) approach.
     * 
     * Space Complexity:
     * - The space complexity is O(n) because of the additional space used for merging arrays.
     */

    int mergesort(int[] arr, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;

        int countinversions = 0;

        countinversions += mergesort(arr, left, mid);
        countinversions += mergesort(arr, mid + 1, right);

        countinversions += countInversions(arr, left, mid, right);

        merge(arr, left, mid, right);

        return countinversions;
    }

    int countInversions(int[] arr, int left, int mid, int right) {
        int count = 0, rightIter = mid + 1;

        // Count the number of reverse pairs
        for (int i = left; i <= mid; i++) {
            while (rightIter <= right && (double) arr[i] > 2 * (double) arr[rightIter]) {
                rightIter++;
            }
            count += rightIter - (mid + 1);
        }

        return count;
    }

    // Merge operation of merge sort
    int merge(int[] arr, int left, int mid, int right) {
        int l = left, r = mid + 1;
        List<Integer> list = new ArrayList<>();

        // Merge two sorted halves
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                list.add(arr[l]);
                l++;
            } else {
                list.add(arr[r]);
                r++;
            }
        }

        // Add remaining elements from the left half
        while (l <= mid) {
            list.add(arr[l]);
            l++;
        }

        // Add remaining elements from the right half
        while (r <= right) {
            list.add(arr[r]);
            r++;
        }

        // Copy the merged list back to the original array
        for (int i = left; i <= right; i++) {
            arr[i] = list.get(i - left);
        }

        return 0;
    }

    public int reversePairs(int[] nums) {
        // A reverse pair is defined as i < j and nums[i] > 2 * nums[j]
        return mergesort(nums, 0, nums.length - 1);
    }
}
