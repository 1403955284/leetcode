/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        // 一个小的九宫格内是否还能填某个数字
        boolean[][] table = new boolean[9][10];
        // 某一行是否还能填某个数字
        boolean[][] x = new boolean[9][10];
        // 某一列是否还能填某个数字
        boolean[][] y = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    table[3*(i / 3) + j / 3][board[i][j] - '0'] = true;
                    x[i][board[i][j] - '0'] = true;
                    y[j][board[i][j] - '0'] = true;
                }
            }
        }
        backtrack(0, 0, table, x, y, board);
    }

    public boolean backtrack(int row, int col, boolean[][] table, boolean[][] x, boolean[][] y, char[][] board) {
        if (row == 9 && col == 0) {
            return true;
        }
        int nextRow = col + 1 == 9 ? row + 1 : row;
        int nextCol = col == 8 ? 0 : col + 1;
        if (board[row][col] != '.') {
            return backtrack(nextRow, nextCol, table, x, y, board);
        }
        for (int num = 1; num <= 9; num++) {
            if (!table[3*(row / 3) + col / 3][num] && !x[row][num] && !y[col][num]) {
                board[row][col] = (char) (num + '0');
                table[3*(row / 3) + col / 3][num] = true;
                x[row][num] = true;
                y[col][num] = true;
                if (backtrack(nextRow, nextCol, table, x, y, board)) {
                    return true;
                }
                table[3*(row / 3) + col / 3][num] = false;
                x[row][num] = false;
                y[col][num] = false;
                board[row][col] = '.';

            }
        }
        return false;
    } 
}
// @lc code=end
