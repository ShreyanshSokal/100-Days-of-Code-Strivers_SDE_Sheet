import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    
    // Approach:
    // 1. Use recursion to explore all possible partitions of the string.
    // 2. For each partition, check if it is a palindrome:
    //    - If it is, recursively check the remaining substring.
    //    - If it's not, skip the partition.
    // 3. Use memoization to store palindromic substrings in a set (dp) to avoid redundant checks.
    
    // Time Complexity (TC): O(2^n * n)
    // Due to the exponential number of substring partitions and palindrome checks.

    // Space Complexity (SC): O(n^2)
    // For storing palindromic substrings in the dp set and storing subsets in ans.
    
    List<List<String>> ans = new ArrayList<>();  // Stores all valid palindrome partitions
    Set<String> dp = new HashSet<>();  // Caches substrings that are already identified as palindromic

    // Function to check if a given substring is a palindrome
    boolean isPalindrome(String s) {
        if (dp.contains(s)) return true;  // Check if already cached
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        dp.add(s);  // Cache the palindrome for future reference
        return true;
    }

    // Recursive function to partition the string and collect valid partitions
    void check(String s, List<String> temp, int i, int n) {
        if (i == n) {  // Base case: if we've processed the entire string
            ans.add(new ArrayList<>(temp));  // Add the current list of partitions to ans
            return;
        }

        // Iterate through possible partitions of the substring
        for (int j = i; j < n; j++) {
            String cur = s.substring(i, j + 1);  // Extract substring from index i to j
            if (isPalindrome(cur)) {  // Check if the current substring is a palindrome
                temp.add(cur);  // Add to temporary list
                check(s, temp, j + 1, n);  // Recur for the remaining string
                temp.remove(temp.size() - 1);  // Backtrack and remove the last added element
            }
        }
    }

    // Main function to initiate recursive palindrome partitioning
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();  // Temporary list to store current partition
        check(s, temp, 0, s.length());  // Start recursive partitioning
        return ans;  // Return the list of all palindrome partitions
    }
}
