class Solution {

    // Approach:
    // 1. First, check if the lengths of `s` and `goal` are the same. If they aren't, `s` cannot be rotated to match `goal`.
    // 2. Concatenate `s` with itself (resulting in `s + s`), which simulates all possible rotations of `s`.
    // 3. Check if `goal` appears as a substring in `s + s`. If it does, `s` can be rotated to match `goal`.
    //    Otherwise, `s` cannot be rotated to form `goal`.

    // Time Complexity (TC): O(n)
    // Where `n` is the length of `s`. Checking the length takes O(1), concatenating `s + s` takes O(n),
    // and checking if `goal` is a substring takes O(n).

    // Space Complexity (SC): O(n)
    // Additional space is used to store the concatenated string `s + s`.

    public boolean rotateString(String s, String goal) {
        // Check if `s` and `goal` have the same length and if `goal` is a substring of `s + s`.
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
