/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] h = new boolean[9][9];
        boolean[][] l = new boolean[9][9];
        boolean[][] g = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int cur = board[i][j] - '1';
                    int index = i / 3 * 3 + j / 3;
                    if (h[i][cur] || l[j][cur] || g[index][cur]) {
                        return false;
                    }
                    h[i][cur] = l[j][cur] = g[index][cur] = true;
                }
            }
        }
        return true;

    }
}
// @lc code=end
