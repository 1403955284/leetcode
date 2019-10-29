import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        // 某一列上是否还可以放置Q
        boolean[] col = new boolean[n];
        // 某一主对角线上是否还可以放置Q
        boolean[] x = new boolean[2 * n - 1];
        // 某一副对角线上是否还可以放置Q
        boolean[] y = new boolean[2 * n - 1];
        StringBuilder str = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            str.append(".");
        }
        backtrack(0, col, x, y, new LinkedList<>(), str, n);
        return count;
    }

    public void backtrack(int row, boolean[] col, boolean[] x, boolean[] y, List<String> cur, StringBuilder str,
            int n) {
        if (cur.size() == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 如果当前位置可以放置Q
            if (!col[i] && !x[n - 1 - (row - i)] && !y[row + i]) {
                StringBuilder tmp = new StringBuilder(str);
                tmp.replace(i, i + 1, "Q");
                List<String> tmpCur = new ArrayList<>(cur);
                tmpCur.add(tmp.toString());
                col[i] = true;
                x[n - 1 - (row - i)] = true;
                y[row + i] = true;
                backtrack(row + 1, col, x, y, tmpCur, str, n);
                // 恢复
                col[i] = false;
                x[n - 1 - (row - i)] = false;
                y[row + i] = false;
            }
        }
    }
}
// @lc code=end
