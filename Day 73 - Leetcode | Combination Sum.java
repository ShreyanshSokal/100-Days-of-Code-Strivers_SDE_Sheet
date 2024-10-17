import java.util.*;

class Solution {

    // Approach:
    // 1. This is a backtracking problem where we are trying to find all combinations of candidates that sum up to a given target.
    // 2. At each recursive step, we decide whether to include the current candidate in the combination or not.
    // 3. We subtract the candidate value from the target if it's picked, and proceed with the same candidate (as we can pick the same candidate multiple times).
    // 4. If the candidate is not picked, we move to the next one.
    // 5. If the target becomes 0, we have found a valid combination, so we add it to the result.

    // Time Complexity (TC): O(2^t) where t is the target value.
    // In the worst case, we explore all combinations of elements, which can be exponential.

    // Space Complexity (SC): O(t) where t is the target value.
    // The space complexity is mainly determined by the recursion depth, which is proportional to the target value.

    void combinations(List<List<Integer>> ds, List<Integer> combo, int[] candidates, int target, int i) {
        if (i == candidates.length || target == 0) {
            // If we reach the end of candidates or the target becomes zero, add the current combination to the result
            if (target == 0) {
                ds.add(new ArrayList<>(combo));
            }
            return;
        }

        if (candidates[i] > target) return; // No point in exploring if the candidate is greater than the target

        // Pick the current candidate and proceed
        combo.add(candidates[i]);
        combinations(ds, combo, candidates, target - candidates[i], i);

        // Backtrack and remove the last element, then explore the not-pick option
        combo.remove(combo.size() - 1);
        combinations(ds, combo, candidates, target, i + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // Sorting to simplify handling
        List<List<Integer>> ds = new ArrayList<>(); // Result list of combinations
        List<Integer> combo = new ArrayList<>(); // Temporary list to store current combination

        // Generate all combinations
        combinations(ds, combo, candidates, target, 0);

        return ds;
    }
}
