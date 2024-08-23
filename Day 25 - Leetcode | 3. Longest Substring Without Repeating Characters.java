
// Problem: Longest Substring Without Repeating Characters
// The task is to find the length of the longest substring in a given string that contains no repeating characters.
// This can be solved efficiently using a sliding window technique with a HashMap.

class Solution {

    // A helper function for the Brute Force approach
    // This function checks if all characters in the string are unique
    // int checkUniqueChars(String str)
    // {
    //     Set<Character> set = new HashSet<>();
    //     for (int i = 0; i < str.length(); i++)
    //     {
    //         set.add(str.charAt(i));
    //     }
    //     return str.length() == set.size() ? set.size() : 0;
    // }

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        if (n == 0) return 0;

        int maxSize = 0;
        int left = 0, right = 0;

        // OPTIMAL APPROACH -> O(n) solution
        // Using a HashMap to store the last seen position of each character
        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char curChar = s.charAt(right);

            // If the current character is already in the map and is within the current window
            if (map.containsKey(curChar)) {
                // Move the left pointer to avoid repeating characters
                left = Math.max(map.get(curChar) + 1, left);
            }
            
            // Calculate the maximum size of the substring
            maxSize = Math.max(maxSize, right - left + 1);
            map.put(curChar, right); // Update the last seen position of the current character

            right++;
        }

        // BETTER APPROACH -> O(2n) solution
        // Using a HashSet to maintain the unique characters in the current window
        // Set<Character> set = new HashSet<>();

        // while (right < n) {
        //     char curStr = s.charAt(right);
            
        //     set.add(curStr);
        //     int curSize = right - left + 1;

        //     // If the set size doesn't match the window size, there are duplicates
        //     if (set.size() != curSize) {
        //         System.out.println("DUPLICATE  " + left + " - " + right);
        //         // Move the left pointer to remove duplicates
        //         while (left <= right && s.charAt(left) != curStr) {
        //             set.remove(s.charAt(left));
        //             left++;
        //         }
        //         left++;
        //     } else {
        //         maxSize = curSize > maxSize ? curSize : maxSize;
        //         right++;
        //     }
        //     System.out.println(left + " - " + right);
        // }

        // BRUTE FORCE APPROACH 
        // Checking all possible substrings for unique characters
        // for (int i = 0; i < n; i++) {
        //     String curStr = "";
        //     for (int j = i; j < n; j++) {
        //         curStr += s.charAt(j);
        //         int curSize = checkUniqueChars(curStr);
        //         maxSize = curSize > maxSize ? curSize : maxSize;
        //     }
        // }

        return maxSize; // Return the length of the longest substring without repeating characters
    }
}


### Explanation:
- **Optimal Approach**:
  - The optimal solution uses a **sliding window** technique with a HashMap to track the last seen index of each character.
  - As the right pointer moves through the string, if the current character has been seen before and is within the current window, the left pointer is adjusted to skip over the duplicate character.
  - The window size is updated at each step, and the maximum size is recorded.

- **Better Approach**:
  - This approach uses a HashSet to maintain the characters in the current window and checks if the window contains all unique characters.
  - If a duplicate is found, the left pointer is adjusted until the window contains only unique characters again.

- **Brute Force Approach**:
  - This method checks every possible substring to see if it contains all unique characters, which results in a time complexity of \(O(n^3)\).

This solution provides a clear and detailed approach to finding the length of the longest substring without repeating characters, with a focus on optimizing time complexity.
