import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Approach:
    // 1. Use backtracking to find all unique combinations of numbers that sum up to the target.
    // 2. For each element, decide to either pick it (and reduce the target) or skip to the next unique element.
    // 3. Skip duplicate elements to ensure only unique combinations are added to the result.

    // Time Complexity (TC): O(2^n)
    // Each element has two choices (pick or not pick), leading to exponential combinations in the worst case.

    // Space Complexity (SC): O(n)
    // Recursive call stack and temporary list storing current combinations.

    List<List<Integer>> ans = new ArrayList<>();  // Stores all unique combinations

    // Recursive function to find all combinations
    void f(List<Integer> temp, int[] candidates, int i, int n, int t) {
        // Print the current temporary list for debugging
        System.out.println(temp);

        // Base case: if target (t) is zero, add a valid combination to ans
        if (t == 0) {
            ans.add(new ArrayList<>(temp));  // Add a copy of temp to the result list
            return;
        }

        // If index exceeds array bounds or target goes negative, stop the recursion
        if (i == n || t < 0) return;

        // Pick the current element
        temp.add(candidates[i]);
        f(temp, candidates, i + 1, n, t - candidates[i]);  // Recur with reduced target
        temp.remove(temp.size() - 1);  // Backtrack by removing the last element

        // Skip duplicates to avoid redundant combinations
        while (i + 1 < n && candidates[i] == candidates[i + 1]) i++;

        // Recur without picking the current element
        f(temp, candidates, i + 1, n, t);
    }

    // Main function to initiate combination sum with unique combinations
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // Sort to handle duplicates efficiently
        f(new ArrayList<>(), candidates, 0, candidates.length, target);  // Start recursive search
        return ans;  // Return the list of all unique combinations
    }
}
