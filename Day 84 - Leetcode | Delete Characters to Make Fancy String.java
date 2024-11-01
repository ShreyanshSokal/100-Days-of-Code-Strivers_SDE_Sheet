class Solution {

    // Approach:
    // 1. Traverse the string `s` and build a new string (`sol`) by appending characters conditionally.
    // 2. For each character, check if it repeats consecutively more than twice. 
    // 3. If so, skip adding it to `sol` to prevent any character from appearing more than twice consecutively.
    // 4. Use a counter to track consecutive occurrences and reset it when a different character is encountered.

    // Time Complexity (TC): O(n)
    // Where `n` is the length of the input string `s`. We traverse the string once.

    // Space Complexity (SC): O(n)
    // We use a StringBuilder (`sol`) to store the resulting string, which could potentially hold `n` characters.

    public String makeFancyString(String s) {
        int count = 1;  // Initialize counter for consecutive characters
        StringBuilder sol = new StringBuilder();
        sol.append(s.charAt(0));  // Start the result with the first character
        char c = s.charAt(0);  // Track the current character for consecutive check

        // Loop through the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            char temp = s.charAt(i);

            // If the current character is the same as the previous, increment the counter
            if (temp == c) {
                count++;
            } else {  // If not, reset the counter and update the current character
                count = 1;
                c = temp;
            }

            // Append the character only if it doesn't exceed two consecutive appearances
            if (count < 3) sol.append(temp);
        }

        // Convert the result to a string and return
        return sol.toString();
    }
}
