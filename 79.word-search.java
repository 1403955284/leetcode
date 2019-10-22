import java.util.Arrays;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                if (bfs(board, i, j, 0, word, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(char[][] board, int i, int j, int index, String word, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || index >= word.length()) {
            return false;
        }

        if (!isVisited[i][j] && index == word.length() - 1 && word.charAt(index) == board[i][j]) {
            return true;
        }
        if (!isVisited[i][j] && board[i][j] == word.charAt(index)) {
            // 得用一个新数组记录
            boolean[][] cur = new boolean[board.length][board[0].length];
            for(int m = 0;m<cur.length;m++){
                for(int n = 0;n<cur[0].length;n++){
                    cur[m][n] = isVisited[m][n];
                }
            }
            cur[i][j] = true;
            return     bfs(board, i + 1, j, index + 1, word, cur) 
                    || bfs(board, i - 1, j, index + 1, word, cur)
                    || bfs(board, i, j + 1, index + 1, word, cur)
                    || bfs(board, i, j - 1, index + 1, word, cur);
        }
        return false;
    }
}
// @lc code=end
