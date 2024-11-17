class Solution {

    /**
     * Intuition:
     * - The Sudoku Solver uses a backtracking approach to fill the board.
     * - Start with the first empty cell and try placing numbers from '1' to '9'.
     * - For each number, check if it's valid in the current row, column, and 3x3 subgrid.
     * - If valid, place the number and recursively solve the rest of the board.
     * - If no solution exists with the current placement, backtrack by resetting the cell and trying the next number.
     * 
     * Time Complexity:
     * - In the worst case, there are 9 choices for each of the 81 cells: O(9^(n*n)).
     * - However, constraints reduce possibilities significantly.
     * 
     * Space Complexity:
     * - O(n*n) for the recursion stack in the worst case.
     */

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Helper function to solve the board using backtracking
    boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    // Try placing numbers '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, c, i, j)) {
                            board[i][j] = c;
                            if (solve(board)) return true; // If solution is found, return true
                            else board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid number can be placed in this cell
                }
            }
        }
        return true; // Board is fully solved
    }

    // Helper function to check if placing 'c' in board[row][col] is valid
    boolean valid(char[][] board, char c, int row, int col) {
        for (int i = 0; i < 9; i++) {
            // Check the row and column
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;

            // Check the 3x3 subgrid
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c) return false;
        }
        return true; // Placement is valid
    }
}
