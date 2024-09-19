/**
 * Problem: Search a 2D Matrix
 * Link: [No specific link] (MEDIUM)
 *
 * This solution performs an efficient search in a 2D matrix where each row is sorted and the first element of each row is greater than the last element of the previous row. 
 * The matrix can be treated as a 1D array, allowing for binary search to be applied directly.
 *
 * Approach:
 * - **Step 1:** Treat the 2D matrix as a flat 1D array with indices ranging from `0` to `n*m-1`.
 *     - Use integer division and modulo to convert these 1D indices back into 2D coordinates: `matrix[mid/m][mid%m]`.
 * - **Step 2:** Apply binary search:
 *     - Compute the middle index `mid = (start + end) / 2`.
 *     - Compare the matrix element at `mid` with the target value.
 *         - If the target is found, return `true`.
 *         - If the target is greater, move the search range to the right (`start = mid + 1`).
 *         - If the target is smaller, move the search range to the left (`end = mid - 1`).
 * - **Step 3:** Return `false` if the target is not found after the loop.
 *
 * Time Complexity: O(log(n * m)) [Efficient binary search]
 * Space Complexity: O(1) [Constant space]
 */

class Solution {
    
    // Function to search a target value in a 2D matrix.
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Get dimensions of the matrix (n: rows, m: columns).
        int n = matrix.length, m = matrix[0].length;
        
        // Initialize the binary search bounds.
        int start = 0, end = n * m - 1;

        // Perform binary search within the flattened matrix.
        while (start <= end) {
            
            // Calculate the middle index.
            int mid = (start + end) / 2;
            
            // Map the 1D index back to the 2D matrix using integer division and modulo.
            System.out.println(matrix[mid/m][mid%m]);  // For debugging purposes.
            
            // Check if the mid element is the target.
            if (matrix[mid / m][mid % m] == target) {
                return true;  // Target found.
            }
            
            // If the mid element is less than the target, search the right half.
            else if (matrix[mid / m][mid % m] < target) {
                start = mid + 1;
            }
            
            // If the mid element is greater than the target, search the left half.
            else {
                end = mid - 1;
            }
        }
        
        // Target not found, return false.
        System.out.println("Exited");  // For debugging purposes.
        return false;
    }
}
