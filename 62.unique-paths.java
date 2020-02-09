/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    private int ans = 0;

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // ============== dfs超时 ==================
    private void dfs(int curM, int curN, int m, int n) {
        if (curM == m - 1 && curN == n - 1) {
            ans++;
            return;
        }
        if (curM + 1 < m) {
            dfs(curM + 1, curN, m, n);
        }
        if (curN + 1 < n) {
            dfs(curM, curN + 1, m, n);
        }
    }
}
// @lc code=end
