import java.util.Arrays;

class Solution {

    int[][] visited;

    // Approach:
    // 1. Using recursion and memoization to find the maximum moves possible from any starting point in the grid.
    // 2. The function `f` performs a recursive search, moving to adjacent cells and comparing values.
    // 3. If a cell has already been visited, we use the stored result from `visited` to save computation.
    // 4. For each cell in the first column, we calculate the maximum moves starting from that cell and update the global maximum.
    
    // Time Complexity (TC): O(n * m)
    // Each cell is visited once, and memoization helps avoid redundant calculations.

    // Space Complexity (SC): O(n * m)
    // The `visited` array stores results for each cell, and the recursive call stack adds to space usage.

    // Recursive function to find the maximum moves from cell (x, y)
    int f(int[][] grid, int x, int y, int prev, int n, int m) {
        // Base case: check if the cell is out of bounds or does not satisfy the increasing order
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] <= prev) return 0;

        // If the cell has already been computed, return the cached result
        if (visited[x][y] != -100) {
            return visited[x][y];
        }

        // Explore three possible moves: diagonal up-right, right, and diagonal down-right
        int first = f(grid, x - 1, y + 1, grid[x][y], n, m);
        int second = f(grid, x, y + 1, grid[x][y], n, m);
        int third = f(grid, x + 1, y + 1, grid[x][y], n, m);

        // Store the maximum result for the current cell in `visited`
        visited[x][y] = Math.max(first, Math.max(second, third));

        // If in the first column, return the computed result; otherwise, add 1 for the current move
        return y == 0 ? visited[x][y] : 1 + visited[x][y];
    }

    // Main function to calculate the maximum moves from the first column of each row
    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        visited = new int[n][m];

        // Initialize the `visited` array to a placeholder value
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -100);
        }

        int max = -11;

        // Iterate over each row in the first column, calculating maximum moves
        for (int i = 0; i < n; i++) {
            int temp = f(grid, i, 0, -1, n, m);
            max = Math.max(temp, max);
        }
        return max;
    }
}
