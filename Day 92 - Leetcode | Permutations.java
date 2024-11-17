import java.util.*;

/**
 * Intuition:
 * - The task is to generate all unique permutations of a given integer array.
 * - Use backtracking to generate permutations by swapping elements at each level of recursion.
 * - A `Set` is used to store permutations to avoid duplicates.
 * - At each level, swap the current index with all other indices, recursively generate further permutations, and backtrack by restoring the original order.
 * 
 * Time Complexity:
 * - O(n * n!), where n is the size of the array:
 *   - There are n! permutations, and for each permutation, we perform an O(n) operation to create a new list.
 * 
 * Space Complexity:
 * - O(n! * n), for storing the permutations in the `Set` and the recursion stack.
 * - Additional O(n) space for the `temp` list used during the conversion of the array to a list.
 */

class Solution {

    // Set to store unique permutations
    Set<List<Integer>> ds = new HashSet<>();
    int[] a;

    // Helper function to convert array to list
    List<Integer> asList(int[] array) {
        List<Integer> temp = new ArrayList<>();
        for (int i : array) {
            temp.add(i);
        }
        return temp;
    }

    // Helper function to swap two elements in the array
    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Recursive function to generate permutations
    void permutations(int i, int n) {
        // Base case: if the current index reaches the size of the array, return
        if (i == n) {
            return;
        }

        // Iterate through all positions to generate permutations
        for (int j = 0; j < n; j++) {
            swap(a, i, j);              // Swap the current element with another
            ds.add(asList(a));          // Add the current permutation to the set
            permutations(i + 1, n);     // Recur for the next index
            swap(a, i, j);              // Backtrack to restore the original array
        }

        // Recur without swapping for the current index
        permutations(i + 1, n);
    }

    // Main function to generate permutations
    public List<List<Integer>> permute(int[] nums) {
        a = nums;                         // Store the input array globally
        permutations(0, nums.length);     // Start generating permutations
        return new ArrayList<>(ds);       // Convert the set to a list and return
    }
}
