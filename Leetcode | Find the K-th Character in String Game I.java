/**
 * Problem: Find the K-th Character in String Game I
 * Link: https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
 *
 * The task is to generate a string based on a specific transformation and then find the k-th character
 * in that string. The transformation involves incrementing each character of the string:
 * - If the character is 'z', it wraps around to 'a'.
 * - For all other characters, it moves to the next character in the alphabet.
 *
 * Approach:
 * - **Step 1:** Define a helper method `gen(String s)` that generates the next transformation
 *     of the given string `s`.
 * - **Step 2:** Initialize a variable `word` with the starting string "a".
 * - **Step 3:** Continuously apply the `gen` method to `word` until its length is at least `k`.
 *     - This ensures that we generate enough characters to access the k-th character.
 * - **Step 4:** Return the character at index `k-1` from the resulting string (converting from 1-based index to 0-based).
 *
 * Time Complexity: O(n), where n is the length of the string when we reach at least k characters.
 * Space Complexity: O(n), since we are storing the generated string.
 */

class Solution {
    
    // Helper function to generate the next string based on the transformation rules.
    String gen(String s) {
        String t = ""; // Initialize an empty string for the new transformation.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'z') {
                t += 'a'; // Wrap around 'z' to 'a'.
                continue;
            }
            // Increment the character by converting to its ASCII value and back.
            t += (char) ((int) s.charAt(i) + 1);
        }
        return t; // Return the generated string.
    }
    
    // Main function to find the k-th character in the transformed string.
    public char kthCharacter(int k) {
        String word = "a"; // Start with the initial string "a".
        
        // Keep generating the string until its length is at least k.
        while (word.length() < k) {
            word += gen(word); // Append the generated transformation.
        }
        
        return word.charAt(k - 1); // Return the k-th character (1-based index).
    }
}

/**
 * Example:
 * Input: k = 3
 * Output: 'c'
 * Explanation:
 * - The transformations go as follows:
 *     1. Initial: "a"
 *     2. gen("a") -> "b" -> Resulting word: "ab"
 *     3. gen("ab") -> "bc" -> Resulting word: "abbc"
 *     4. gen("abbc") -> "abcd" -> Resulting word: "abbcabcd"
 * - The length of "abbcabcd" is now greater than 3.
 * - The 3rd character (index 2) is 'c'.
 */
