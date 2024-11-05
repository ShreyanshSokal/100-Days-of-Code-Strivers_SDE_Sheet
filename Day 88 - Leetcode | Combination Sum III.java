import java.util.ArrayList;
import java.util.List;

class Solution {

    // Helper function for recursive backtracking to find valid combinations
    // Parameters:
    // - sol: List to store all valid combinations
    // - ds: Current combination being constructed
    // - i: Current number being considered in the range [1-9]
    // - n: Remaining target sum to reach
    // - k: Remaining number of elements to choose

    // Approach:
    // 1. Base Case 1: If `i` exceeds 9, we return since only numbers 1-9 are allowed.
    // 2. Base Case 2: If `k == 0` and `n == 0`, it means a valid combination is found,
    //    so add a copy of `ds` to `sol`.
    // 3. Recursive Case:
    //    - Option 1: Pick `i` by adding it to `ds`, decrease target sum `n` by `i`, and `k` by 1.
    //    - Option 2: Do not pick `i`, remove it from `ds`, and continue with the next number.
    
    // Time Complexity (TC): O(2^9)
    // Since each number from 1-9 has two choices (pick or not pick), there are at most 2^9 possibilities.

    // Space Complexity (SC): O(k)
    // Where `k` is the maximum depth of recursion due to the path storage in `ds`.

    void f(List<List<Integer>> sol, List<Integer> ds, int i, int n, int k) {
        System.out.println(i);  // Debug print for the current number being considered
        if (i > 9) return;  // Base case for numbers outside range [1-9]
        
        if (k == 0 && n == 0) {
            sol.add(new ArrayList<>(ds));  // Found valid combination
            return;
        }

        if (n < 0 || k < 0) return;  // Prune search if target or number of elements exceed constraints

        // Option 1: Pick the current number `i`
        ds.add(i);
        f(sol, ds, i + 1, n - i, k - 1);

        // Option 2: Do not pick the current number `i`
        ds.remove(ds.size() - 1);
        f(sol, ds, i + 1, n, k);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> sol = new ArrayList<>();  // List to store all combinations
        List<Integer> ds = new ArrayList<>();  // Temporary list to store current path
        f(sol, ds, 1, n, k);  // Start recursive function with number `1`
        return sol;
    }
}
