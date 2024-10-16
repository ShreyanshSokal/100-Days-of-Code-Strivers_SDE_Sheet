import java.util.*;

class Solution {

    // Approach:
    // 1. The problem asks to generate all possible subsets of a given array, including duplicate subsets.
    // 2. We use recursion to generate the subsets. For each element, we have two choices:
    //    a) Include the current element in the subset.
    //    b) Exclude the current element from the subset.
    // 3. We use a set to store the subsets to avoid duplicates, since duplicate elements can lead to identical subsets.
    // 4. Before starting, we sort the input array to ensure that duplicate elements are adjacent, which helps in avoiding redundant subsets.

    // Time Complexity (TC): O(2^n * n)
    // There are 2^n subsets for an array of size n, and for each subset, copying it into the result takes O(n) time.

    // Space Complexity (SC): O(2^n * n)
    // We need O(2^n) space to store the subsets, and each subset can have up to n elements.

    void f(int[] nums, Set<List<Integer>> subsets, int i, List<Integer> ds) {
        if (i == nums.length) {
            // Add the subset when we've considered all elements
            subsets.add(new ArrayList<>(ds));
            return;
        }
        
        // Include the current element in the subset
        ds.add(nums[i]);
        f(nums, subsets, i + 1, ds);

        // Exclude the current element from the subset
        ds.remove(ds.size() - 1);
        f(nums, subsets, i + 1, ds);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        Set<List<Integer>> subsets = new HashSet<>(); // Using set to avoid duplicate subsets
        List<Integer> ds = new ArrayList<>(); // Temporary list to store current subset
        int i = 0;

        // Generate all subsets
        f(nums, subsets, i, ds);

        // Convert the set to a list and return
        return new ArrayList<>(subsets);
    }
}
