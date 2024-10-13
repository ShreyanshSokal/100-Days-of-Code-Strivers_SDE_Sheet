class Solution {

    // Approach:
    // 1. We maintain two balance checks, one from left to right (leftBalance) and one from right to left (rightBalance).
    // 2. When iterating from left to right, we increment leftBalance for '(' and '*' and decrement it for ')'.
    //    - If leftBalance becomes negative, it means there are unmatched ')' at some point, so we return false.
    // 3. When iterating from right to left, we do the same but increment for ')' and '*' and decrement for '('.
    //    - If rightBalance becomes negative, it means there are unmatched '(' from the right side, so we return false.
    // 4. If both balances are non-negative during the iterations, the string is valid.

    // Time Complexity (TC): O(n)
    // We traverse the string twice, so the overall time complexity is O(n), where n is the length of the string.

    // Space Complexity (SC): O(1)
    // We are using a constant amount of extra space (leftBalance, rightBalance), so the space complexity is O(1).

    public boolean checkValidString(String s) {
        int leftBalance = 0, rightBalance = 0, n = s.length();

        // First pass: Left to right
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') leftBalance++; // Increment for '(' or '*'
            else leftBalance--; // Decrement for ')'

            if (leftBalance < 0) return false; // If we have unmatched ')'
        }

        // Second pass: Right to left
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') rightBalance++; // Increment for ')' or '*'
            else rightBalance--; // Decrement for '('

            if (rightBalance < 0) return false; // If we have unmatched '('
        }

        // If both passes are valid, return true
        return true;
    }
}
