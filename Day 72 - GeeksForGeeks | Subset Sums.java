import java.util.*;

class Solution {

    // Approach:
    // 1. The task is to find all possible subset sums of a given array.
    // 2. We use recursion to generate all subsets. For each element in the array, there are two choices:
    //    a) Include the current element in the subset and add its value to the sum.
    //    b) Exclude the current element from the subset.
    // 3. Once all subsets are considered, we store the sum of each subset in a list.
    // 4. The subset sums are then sorted in ascending order and returned as the result.

    // Time Complexity (TC): O(2^n + 2^n * log(2^n)) ≈ O(2^n)
    // There are 2^n subsets for an array of size n, and sorting them takes O(2^n * log(2^n)) time.

    // Space Complexity (SC): O(2^n)
    // We need O(2^n) space to store the sum of each subset.

    void f(int i, ArrayList<Integer> arr, ArrayList<Integer> sumlist, int n, int sum) {
        if (i == n) {
            sumlist.add(sum); // Base case: all elements considered
            return;
        }

        // Include the current element in the sum
        f(i + 1, arr, sumlist, n, sum + arr.get(i));

        // Exclude the current element from the sum
        f(i + 1, arr, sumlist, n, sum);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> sumlist = new ArrayList<>();
        
        // Recursively calculate all subset sums
        f(0, arr, sumlist, n, 0);

        // Sort the sumlist in ascending order
        Collections.sort(sumlist);

        return sumlist;
    }
}
