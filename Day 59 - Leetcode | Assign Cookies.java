/**
 * Problem: Assign Cookies (EASY)
 * Link: [No specific link]
 *
 * The goal is to assign cookies to children such that the number of content children is maximized. 
 * A child can be content if the size of the cookie given is greater than or equal to their greed factor.
 *
 * Approach:
 * - **Step 1:** Sort both the greed factor array (`g[]`) and the cookie sizes array (`s[]`) to use the smallest available cookies for the least greedy children.
 * - **Step 2:** Use two pointers, one (`iterG`) to iterate over the greed factor array, and another (`iterS`) to iterate over the cookie sizes array.
 *     - For each cookie, check if it can satisfy the current child's greed. If yes, move to the next child.
 *     - Move to the next cookie in every iteration.
 * - **Step 3:** Continue this until we either run out of cookies or children.
 *
 * Time Complexity: O(n log n), where `n` is the maximum length of the two arrays (due to sorting).
 * Space Complexity: O(1), no extra space used beyond the input arrays.
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Step 1: Handle edge case where either the greed or cookie arrays are empty.
        if (g.length == 0 || s.length == 0) return 0;

        // Step 2: Sort both greed factors and cookie sizes to match smallest cookies with least greedy children.
        Arrays.sort(g);
        Arrays.sort(s);

        // Step 3: Initialize two pointers to track the child (`iterG`) and the cookie (`iterS`).
        int iterG = 0, iterS = 0;

        // Step 4: Iterate over the cookies, trying to satisfy the children's greed.
        while (iterS < s.length) {
            if (iterG >= g.length) break; // If all children are satisfied, stop.

            // If the current cookie can satisfy the current child's greed, move to the next child.
            if (g[iterG] <= s[iterS]) {
                iterG++; // Move to the next child.
            }
            
            // Move to the next cookie in every iteration.
            iterS++;
        }

        // Step 5: Return the number of content children (i.e., how many children were satisfied).
        return iterG;
    }
}

/**
 * Example:
 * Input: g = [1, 2, 3], s = [1, 1]
 * Output: 1
 * Explanation:
 * - Only one child can be satisfied: 
 *     - The first child has a greed factor of 1, and we have a cookie of size 1 for them.
 *     - The other children have higher greed factors, and we don't have enough cookies to satisfy them.
 */
