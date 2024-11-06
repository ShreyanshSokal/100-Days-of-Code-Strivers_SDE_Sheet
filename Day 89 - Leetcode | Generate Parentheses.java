import java.util.ArrayList;
import java.util.List;

class Solution {

    // sol stores all valid combinations of parentheses
    List<String> sol = new ArrayList<>();

    // Recursive helper function to generate all valid parentheses combinations
    // Parameters:
    // - s: Current string of parentheses being built
    // - open: Count of open parentheses '(' used so far
    // - close: Count of close parentheses ')' used so far
    // - n: Total pairs of parentheses required

    // Approach:
    // 1. Base Case: If the length of `s` reaches 2 * n (meaning we used all `n` pairs),
    //    we add the current combination `s` to sol and return.
    // 2. Recursive Cases:
    //    - Option 1: Add an open parenthesis '(' if `open` count is less than `n`.
    //    - Option 2: Add a close parenthesis ')' if `close` count is less than `open`,
    //      ensuring we close an open parenthesis only if there's an unmatched open one.

    // Time Complexity (TC): O(4^n / √n)
    // Since each parenthesis has two choices (open or close), and valid combinations are 
    // generated recursively, resulting in Catalan number complexity.

    // Space Complexity (SC): O(n)
    // Maximum depth of recursion due to constructing each valid path up to length `2 * n`.

    void generateParenthesis(String s, int open, int close, int n) {
        if (s.length() == n * 2) {  // Base case: reached the required length
            sol.add(s);  // Add the valid combination to the solution
            return;
        }

        // Option 1: Add an open parenthesis if open count is less than `n`
        if (open < n) generateParenthesis(s + '(', open + 1, close, n);

        // Option 2: Add a close parenthesis if close count is less than open
        if (close < open) generateParenthesis(s + ')', open, close + 1, n);
    }

    public List<String> generateParenthesis(int n) {
        generateParenthesis("", 0, 0, n);  // Start recursive function with an empty string
        return sol;  // Return all valid combinations
    }
}
