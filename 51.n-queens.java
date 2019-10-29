import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 某一列上是否还可以放置Q
        boolean[] col = new boolean[n];
        // 某一主对角线上是否还可以放置Q
        boolean[] x = new boolean[2 * n - 1];
        // 某一副对角线上是否还可以放置Q
        boolean[] y = new boolean[2 * n - 1];
        List<List<String>> ans = new LinkedList<>();
        StringBuilder str = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            str.append(".");
        }
        backtrack(0, col, x, y, new LinkedList<>(), ans, str, n);
        return ans;

    }

    public void backtrack(int row, boolean[] col, boolean[] x, boolean[] y, List<String> cur, List<List<String>> ans,
            StringBuilder str, int n) {
        if (cur.size() == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 如果当前位置可以放置Q
            if (!col[i] && !x[n - 1 - (row - i)] && !y[row + i]) {
                // StringBuilder tmp = new StringBuilder(n);
                // for (int k = 0; k < n; k++) {
                // if (k == i) {
                // tmp.append("Q");
                // } else {
                // tmp.append(".");
                // }
                // }
                StringBuilder tmp = new StringBuilder(str);
                tmp.replace(i, i + 1, "Q");
                List<String> tmpCur = new ArrayList<>(cur);
                tmpCur.add(tmp.toString());
                col[i] = true;
                x[n - 1 - (row - i)] = true;
                y[row + i] = true;
                backtrack(row + 1, col, x, y, tmpCur, ans, str, n);
                // 恢复
                col[i] = false;
                x[n - 1 - (row - i)] = false;
                y[row + i] = false;
            }
        }
    }

}
// @lc code=end
