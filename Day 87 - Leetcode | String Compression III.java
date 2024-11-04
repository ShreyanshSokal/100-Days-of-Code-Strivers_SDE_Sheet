class Solution {

    // Approach:
    // 1. Initialize a `StringBuilder` to build the compressed string.
    // 2. Use two pointers (`i` and `j`) to track characters and their consecutive occurrences.
    // 3. `cur` stores the current character at index `i`.
    // 4. Move `j` to count consecutive occurrences of `cur` (up to a maximum of 9 to prevent overflow).
    // 5. Append the count (`j - i`) and the character `cur` to `sb`.
    // 6. Update `i` to `j` to continue compressing the rest of the string.
    // 7. Finally, return the compressed string stored in `sb`.

    // Time Complexity (TC): O(n)
    // Where `n` is the length of `word`. We traverse the string once, so the time complexity is linear.

    // Space Complexity (SC): O(n)
    // Additional space is used for storing the compressed string in `StringBuilder`.

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();  // To store the result
        int n = word.length(), i = 0;
        
        while (i < n) {
            int j = i;  // Start counting occurrences from index `i`
            char cur = word.charAt(i);  // Get the current character
            
            // Move `j` while characters match and limit to 9 consecutive occurrences
            while (j < n && j < i + 9 && word.charAt(j) == cur) {
                j++;
            }
            
            sb.append(j - i);  // Append the count of consecutive characters
            sb.append(cur);  // Append the character itself
            i = j;  // Move `i` to the next new character
        }
        
        return sb.toString();
    }
}
