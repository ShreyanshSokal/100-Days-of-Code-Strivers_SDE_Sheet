import java.util.*;

class Solution {

    /**
     * Intuition:
     * - This is a classic backtracking problem where the rat starts at (0, 0) 
     *   and explores all possible paths to reach the bottom-right corner.
     * - At each cell, the rat can move in one of four directions: down, left, right, or up.
     * - Use recursion to explore paths and backtrack if the current path doesn't lead to the destination.
     * - Mark cells as visited to avoid cycles.
     * 
     * Time Complexity: O(4^(n^2))
     * - In the worst case, each cell may have up to 4 recursive calls.
     * - There are n x n cells, leading to 4^(n^2) total calls.
     * 
     * Space Complexity: O(n^2)
     * - For the recursion stack in the worst case.
     * - Additionally, a visited array of size n x n is used.
     */
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        
        // Helper function to perform backtracking
        solve(0, 0, m, n, visited, "", paths);
        return paths;
    }

    private static void solve(int x, int y, int[][] maze, int n, boolean[][] visited, String path, ArrayList<String> paths) {
        // Base case: If the rat reaches the bottom-right corner, add the path to results
        if (x == n - 1 && y == n - 1) {
            paths.add(path);
            return;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Move in all four directions: Down, Left, Right, Up
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] directions = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // Check if the new cell is valid for movement
            if (isValid(newX, newY, maze, n, visited)) {
                solve(newX, newY, maze, n, visited, path + directions[i], paths);
            }
        }

        // Backtrack: Mark the current cell as unvisited
        visited[x][y] = false;
    }

    private static boolean isValid(int x, int y, int[][] maze, int n, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1 && !visited[x][y];
    }
}
