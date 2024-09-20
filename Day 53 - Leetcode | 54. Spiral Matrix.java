/**
 * Problem: Spiral Matrix
 * Link: [No specific link] (MEDIUM)
 *
 * This solution generates a list of matrix elements traversed in spiral order. The traversal starts from the top-left corner and moves in the following order: 
 * - Left to right (top row), 
 * - Top to bottom (right column), 
 * - Right to left (bottom row),
 * - Bottom to top (left column), and repeats inward.
 *
 * Approach:
 * - **Step 1:** Initialize boundaries for the rows (`t` for top and `b` for bottom) and columns (`l` for left and `r` for right).
 * - **Step 2:** Traverse the matrix in a spiral order:
 *     - Traverse the top row from left to right.
 *     - Traverse the right column from top to bottom.
 *     - If there are rows remaining, traverse the bottom row from right to left.
 *     - If there are columns remaining, traverse the left column from bottom to top.
 * - **Step 3:** After each complete traversal of a row or column, adjust the boundaries (`t`, `b`, `l`, `r`) to move inward.
 * - **Step 4:** The loop terminates when the boundaries overlap, and the list of matrix elements in spiral order is returned.
 *
 * Time Complexity: O(n * m) [Each element of the matrix is visited once]
 * Space Complexity: O(n * m) [Output list to store all elements in the matrix]
 */

class Solution {
    
    // Function to return a list of elements in spiral order from a matrix.
    public List<Integer> spiralOrder(int[][] matrix) {
        
        // `b`: bottom boundary, `r`: right boundary
        int b = matrix.length;
        int r = matrix[0].length;
        
        // `a`: list to store elements in spiral order, `t`: top boundary, `l`: left boundary
        List<Integer> a = new LinkedList<>();
        int t = 0, l = 0;

        // Traverse the matrix until boundaries overlap.
        while (l < r && t < b) {
            
            // Traverse top row (left to right).
            for (int i = l; i < r; i++) a.add(matrix[t][i]);
            
            // Traverse right column (top to bottom).
            for (int i = t + 1; i < b; i++) a.add(matrix[i][r - 1]);
            
            // Check if we have already processed the entire matrix.
            if (b - 1 <= t) break;
            
            // Traverse bottom row (right to left).
            for (int i = r - 2; i >= l; i--) a.add(matrix[b - 1][i]);
            
            // Check if we have already processed the entire matrix.
            if (r - 1 <= l) break;
            
            // Traverse left column (bottom to top).
            for (int i = b - 2; i > t; i--) a.add(matrix[i][l]);

            // Move the boundaries inward after each complete layer traversal.
            t++;  // Move top boundary down.
            b--;  // Move bottom boundary up.
            l++;  // Move left boundary right.
            r--;  // Move right boundary left.
        }
        
        // Return the list of matrix elements in spiral order.
        return a;
    }
}
