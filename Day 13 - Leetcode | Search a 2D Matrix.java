class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /** 
         * Problem Description:
         * You are given a 2D matrix where each row is sorted in ascending order,
         * and each column is sorted from top to bottom. The task is to search
         * for a given target value in the matrix. Return true if the target exists 
         * in the matrix, otherwise return false.
         * 
         * Intuition:
         * The matrix is sorted row-wise and column-wise, which allows us to treat 
         * the matrix as a flattened sorted 1D array. By mapping the 2D indices to 
         * 1D indices, we can apply binary search to efficiently locate the target element.
         * 
         * Approach:
         * 1. Matrix Dimensions:
         *    - Let 'n' be the number of rows and 'm' be the number of columns in the matrix.
         *    - The matrix can be thought of as a 1D array of length 'n * m'.
         * 
         * 2. Binary Search Setup:
         *    - Initialize two pointers, 'start' at 0 and 'end' at 'n * m - 1', representing 
         *      the indices of the imaginary 1D array.
         * 
         * 3. Binary Search Process:
         *    - Calculate the middle index 'mid' using '(start + end) / 2'.
         *    - Convert this 1D index back to a 2D index using 'mid / m' for the row index 
         *      and 'mid % m' for the column index.
         *    - Compare the matrix element at this position with the target:
         *      - If it equals the target, return true.
         *      - If it is less than the target, move the 'start' pointer to 'mid + 1'.
         *      - If it is greater than the target, move the 'end' pointer to 'mid - 1'.
         *    - Continue this process until 'start' exceeds 'end'.
         * 
         * 4. Exit Condition:
         *    - If the loop exits without finding the target, return false.
         * 
         * Time Complexity:
         * - The time complexity of this approach is O(log(n * m)). This is because 
         *   the binary search is applied on a 1D array of length 'n * m', making the 
         *   algorithm logarithmic in the size of the matrix.
         * 
         * Space Complexity:
         * - The space complexity is O(1) as the algorithm uses a constant amount of 
         *   extra space, regardless of the size of the input matrix.
         */
        
        int n = matrix.length, m = matrix[0].length;
        int start = 0, end = n * m - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(matrix[mid / m][mid % m]);

            if (matrix[mid / m][mid % m] == target) {
                return true;
            } else if (matrix[mid / m][mid % m] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println("Exited");
        return false;
    }
}
```
