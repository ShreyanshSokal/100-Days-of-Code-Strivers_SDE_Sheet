import java.util.*;

// asList Method: Converts an integer array to a List<Integer>, needed because HashSet stores only lists for this problem.

// swap Method: Swaps elements in the array to modify the order and create new permutations.

// permutations Recursive Method:

// Swaps elements from the current index i through n to generate new permutations.
// After each swap, it recursively calls itself to explore further permutations from the next index.
// Uses backtracking by swapping elements back to restore the original array state for the next iteration.
// permute Method: Initiates the process with nums, calling permutations and returning the final list of unique permutations from ds.

// Complexity Analysis
// Time Complexity: Roughly O(n!), due to generating all unique permutations.
// Space Complexity: O(n!) for storing all unique permutations in the set.

class Solution {

    // Set to store unique permutations as lists.
    Set<List<Integer>> ds = new HashSet<>();
    
    // Array to hold input numbers for manipulation.
    int[] a;

    // Helper method to convert array to a List.
    // This is necessary because Set only accepts Lists in this implementation.
    List<Integer> asList(int[] array) {
        List<Integer> temp = new ArrayList<>();
        for (int i : array) {
            temp.add(i);
        }
        return temp;
    }

    // Helper method to swap elements in the array.
    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Recursive method to generate all permutations of the array.
    // Parameters:
    // - i: The current index in the array to start swapping from.
    // - n: The length of the array (or subset length in recursion).
    void permutations(int i, int n) {
        if (i == n) {
            return;  // Base case: end of array reached.
        }

        // Loop through the array to generate unique permutations by swapping.
        for (int j = 0; j < n; j++) {
            swap(a, i, j);  // Swap elements to create a new permutation.
            ds.add(asList(a));  // Add the current permutation to the set.
            permutations(i + 1, n);  // Recurse to generate further permutations.
            swap(a, i, j);  // Swap back to restore the original state for backtracking.
        }

        // Recursive call without swapping to continue exploring further possibilities.
        permutations(i + 1, n);
    }

    // Main function to initiate permutation generation.
    public List<List<Integer>> permute(int[] nums) {
        a = nums;  // Initialize `a` with input array `nums`.
        
        // Generate all unique permutations starting from index 0.
        permutations(0, nums.length);

        // Convert the set of permutations to a list and return.
        return new ArrayList<>(ds);
    }
}
