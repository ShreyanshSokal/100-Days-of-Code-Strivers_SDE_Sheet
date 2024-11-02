class Solution {

    // Approach:
    // 1. Split the sentence by spaces to get each word as an individual string in an array `s`.
    // 2. Check if the sentence forms a circular sequence by verifying:
    //    a. The first character of the first word matches the last character of the last word.
    //    b. For each word in the list, the last character of the previous word matches the first character of the current word.
    // 3. If all conditions are met, the sentence is circular.

    // Time Complexity (TC): O(n)
    // Where `n` is the number of words in the sentence. The split operation and the loop both take O(n) time.

    // Space Complexity (SC): O(n)
    // Space is used for storing the words in the `s` array.

    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] s = sentence.split(" ");
        int n = s.length;

        // Check if the last character of the last word matches the first character of the first word
        if (s[0].charAt(0) != s[n - 1].charAt(s[n - 1].length() - 1)) {
            return false;
        }

        // Loop through each pair of consecutive words
        for (int i = 1; i < n; i++) {
            // If the last character of the previous word doesn't match the first character of the current word, return false
            if (s[i - 1].charAt(s[i - 1].length() - 1) != s[i].charAt(0)) {
                return false;
            }
        }

        // If all checks are passed, the sentence is circular
        return true;
    }
}
