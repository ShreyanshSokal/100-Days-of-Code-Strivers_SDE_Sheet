/*
Intuition:
The intuition behind this problem is to merge two sorted arrays into a single sorted array. Since both arrays are already sorted, we can leverage this property to perform an efficient merge operation by comparing the elements from both arrays one by one and placing the smaller element into the result array.

Approach:
Initialization:

-Create a new array ans of size m + n to store the merged result.
-Use three pointers: im for nums1, in for nums2, and ia for ans.

Merging:

-Use a while loop to iterate through both arrays as long as neither array has been fully traversed.
-Compare the current elements of nums1 and nums2.
-- If nums1[im] is smaller or equal, assign ans[ia] to nums1[im] and increment im.
-- Otherwise, assign ans[ia] to nums2[in] and increment in.
-Increment ia to move to the next position in the ans array.
Remaining Elements:

-If there are any remaining elements in nums1, add them to ans.
-If there are any remaining elements in nums2, add them to ans.
Copying Back:

-Copy the merged elements from ans back to nums1.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int im = 0, in = 0, ia = 0;
        
        while (im < m && in < n) {
            if (nums1[im] <= nums2[in]) {
                ans[ia] = nums1[im];
                im++;
            } else {
                ans[ia] = nums2[in];
                in++;
            }
            ia++;
        }
        
        while (im < m) {
            ans[ia++] = nums1[im++];
        }
        
        while (in < n) {
            ans[ia++] = nums2[in++];
        }
        
        for (int i = 0; i < ans.length; i++) {
            nums1[i] = ans[i];
        }        
    }
}
