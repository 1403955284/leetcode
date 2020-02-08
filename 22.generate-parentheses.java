import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return ans;
        }
        bfs(new StringBuilder(), 0, 0, 2 * n);
        return ans;
    }

    private void bfs(StringBuilder cur, int l, int r, int n) {
        if (l < r) {
            return;
        }
        if (cur.length() > n) {
            return;
        }
        if (l == r && cur.length() == n) {
            ans.add(cur.toString());
            return;
        }
        bfs(new StringBuilder(cur).append('('), l + 1, r, n);
        bfs(new StringBuilder(cur).append(')'), l, r + 1, n);
    }
}
// @lc code=end
