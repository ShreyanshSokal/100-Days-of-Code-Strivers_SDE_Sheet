/*
### Problem Description:
An **inversion** in an array is a pair of elements such that the earlier element is greater than the later element. For example, in the array `[2, 4, 1, 3, 5]`, the pairs `(2, 1)`, `(4, 1)`, and `(4, 3)` are inversions. The task is to count the number of such inversions in the given array.

### Intuition:
The problem can be efficiently solved using the Divide and Conquer technique, similar to Merge Sort. The key idea is to count inversions while merging two sorted halves of the array. When merging, if an element from the right half is smaller than an element from the left half, then it forms an inversion with all the remaining elements in the left half, since the left half is sorted.

### Approach:
1. **Divide**:
   - Split the array into two halves using the middle index, and recursively sort and count inversions in each half.

2. **Conquer (Merge and Count)**:
   - During the merge step, count the inversions. If an element from the right half is smaller than an element from the left half, it means that all remaining elements in the left half will form an inversion with this element.

3. **Combine**:
   - Sum up the inversions counted during the merge steps along with those counted in the left and right halves.

### Code Explanation:

*/
  
public static long getInversions(long arr[], int n) {
    return mergesort(arr, 0, n-1);
}

//getInversions`: This function starts the Merge Sort process by calling `mergesort` on the entire array.


static long mergesort(long[] arr, int left, int right) {
    if (left >= right) return 0;
    long countinversions = 0;
    int mid = (left + right) / 2;
    countinversions += mergesort(arr, left, mid);
    countinversions += mergesort(arr, mid+1, right);
    countinversions += merge(arr, left, mid, right);
    return countinversions;
}

//mergesort`: This function recursively splits the array into halves and counts the inversions in each half and during the merge step.
  
static long merge(long[] arr, int left, int mid, int right) {
    long countinversions = 0;
    int l = left, r = mid+1;
    List<Long> list = new ArrayList<>();
    while (l <= mid && r <= right) {
        if (arr[l] <= arr[r]) {
            list.add(arr[l]);
            l++;
        } else {
            list.add(arr[r]);
            r++;
            countinversions += (mid - l + 1);
        }
    }
    while (l <= mid) {
        list.add(arr[l]);
        l++;
    }
    while (r <= right) {
        list.add(arr[r]);
        r++;
    }
    for (int i = left; i <= right; i++) {
        arr[i] = list.get(i-left);
    }
    return countinversions;
}

//merge`: This function merges two sorted halves of the array while counting the inversions. If an element from the right half (`arr[r]`) is smaller than an element from the left half (`arr[l]`), it forms an inversion with every remaining element in the left half (`mid - l + 1`).

/* 
  
### Time Complexity:
- The time complexity of this algorithm is `O(n log n)`, which is the time complexity of Merge Sort. This is because we are performing the merge operation on `n` elements and the merge sort divides the array into halves log(n) times.

### Space Complexity:
- The space complexity is `O(n)` due to the use of a temporary list during the merge step. This list is used to store elements while merging the two halves.

This approach efficiently counts the number of inversions in the array, leveraging the properties of Merge Sort to maintain a good time complexity.

*/
