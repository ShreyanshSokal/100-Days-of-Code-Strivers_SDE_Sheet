class Solution {
    /**
     * Problem Description:
     * You are given two integers `m` and `n` representing a grid of `m x n` size. 
     * You are initially positioned at the top-left corner of the grid (0, 0) and 
     * you are supposed to move to the bottom-right corner (m-1, n-1). You can only 
     * move either down or right at any point in time. The task is to find the 
     * number of unique paths from the top-left corner to the bottom-right corner.
     * 
     * Intuition:
     * The problem can be solved using **Dynamic Programming (DP)**. The main idea is 
     * to break down the problem into smaller subproblems and store the results of 
     * subproblems to avoid redundant calculations.
     * 
     * - The number of unique paths to reach a cell (x, y) is the sum of the unique 
     *   paths to reach the cell directly above it (x-1, y) and the cell directly to 
     *   the left of it (x, y-1). This is because you can only move either down or right.
     * - If you reach the bottom-right corner (m-1, n-1), there is exactly one way to do so.
     * - If you go out of bounds of the grid, that path is invalid, and it should return 0.
     * 
     * Approach:
     * 1. Use a 2D DP array `dp` where `dp[x][y]` represents the number of unique paths 
     *    to reach the cell (x, y).
     * 2. Initialize the `dp` array with -1, indicating uncalculated paths.
     * 3. Implement a recursive function `travel(m, n, x, y, dp)` that calculates the 
     *    number of paths to reach the cell (x, y):
     *    - If the current cell is out of bounds, return 0.
     *    - If the current cell is the bottom-right corner, return 1.
     *    - If the value at `dp[x][y]` is already calculated, return that value to avoid 
     *      redundant calculations.
     *    - Calculate the number of paths by moving right (`x+1, y`) and down (`x, y+1`).
     *    - Store the sum of these paths in `dp[x][y]`.
     * 4. Start the calculation from the top-left corner (0, 0).
     * 
     * Time Complexity:
     * - The time complexity is O(m * n) because each cell is computed only once and stored 
     *   in the DP array.
     * 
     * Space Complexity:
     * - The space complexity is O(m * n) due to the use of the 2D DP array.
     */
    
    int travel(int m, int n, int x, int y, int[][] dp) {
        // Out of bounds
        if (x >= m || y >= n) {
            return 0;
        }

        // Reached the end
        if (x == m - 1 && y == n - 1) {
            return 1; // There's exactly 1 way to reach the end
        }

        // If already computed, return the stored value
        if (dp[x][y] != -1) return dp[x][y];

        // Calculate the number of ways by moving right and down
        int wayRight = travel(m, n, x + 1, y, dp); // move right
        int wayDown = travel(m, n, x, y + 1, dp);  // move down

        // Store the result in dp array
        dp[x][y] = wayRight + wayDown;

        return dp[x][y];
    }

    public int uniquePaths(int m, int n) {
        // Initialize the DP array
        int[][] dp = new int[m][n];

        // Fill the DP array with -1 (indicating uncalculated paths)
        for (int[] i : dp) Arrays.fill(i, -1);

        // Start the path calculation from the top-left corner (0, 0)
        return travel(m, n, 0, 0, dp);
    }
}
