class Solution {

    // Approach:
    // 1. We generate a sequence of strings that progressively transforms the empty string into the target string.
    // 2. For each character in the target string:
    //    - We append 'a' first.
    //    - Then, we increment the character from 'a' until it matches the corresponding character in the target string.
    // 3. This continues until the entire target string is formed.
    
    // Time Complexity (TC): O(n * m)
    // where n is the length of the target string and m is the average number of steps required to match each character 
    // (up to 26 for letters from 'a' to 'z').

    // Space Complexity (SC): O(n)
    // We store the generated sequence of strings, which grows in size linearly with the target string.

    public List<String> stringSequence(String target) {
        String s = "";  // Holds the current string being built
        int n = target.length(), i = 0;
        List<String> list = new ArrayList<>();  // List to store the sequence of strings
        
        while (i != n) {

            // Step 1: Append 'a' as the starting character
            list.add(s + 'a');
            
            char c = 'a';  // Start with 'a'
            
            // Step 2: Increment the character until it matches the target character at position i
            while (c != target.charAt(i)) {
                c++;
                list.add(s + c);  // Add the updated string to the list
            }   

            // Append the matched character to the string 's'
            s += c;
            i++;  // Move to the next character in the target string
        }
        
        return list;  // Return the list of generated strings
    }
}
