/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start
class Solution {
    // ==================================
    // 参考:https://blog.csdn.net/luke2834/article/details/79365645
    // ==================================
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[2 * n - 1][n][n];
        dp[0][0][0] = grid[0][0];
        for (int step = 1; step < 2 * n - 1; step++) {
            for (int i = 0; i < n; i++) {
                for (int p = 0; p < n; p++) {
                    dp[step][i][p] = -1;
                    int j = step - i;
                    int q = step - p;
                    if (j < 0 || q < 0 || j >= n || q >= n) {
                        continue;
                    }
                    if (grid[i][j] <= -1 || grid[p][q] <= -1) {
                        dp[step][i][p] = -1;
                    } else {
                        if (i > 0) {
                            dp[step][i][p] = Math.max(dp[step][i][p], dp[step - 1][i - 1][p]);
                        }
                        if (p > 0) {
                            dp[step][i][p] = Math.max(dp[step][i][p], dp[step - 1][i][p - 1]);
                        }
                        if (i > 0 && p > 0) {
                            dp[step][i][p] = Math.max(dp[step][i][p], dp[step - 1][i - 1][p - 1]);
                        }
                        dp[step][i][p] = Math.max(dp[step][i][p], dp[step - 1][i][p]);
                        if (dp[step][i][p] == -1) {
                            continue;
                        } else {
                            if (i != p) {
                                dp[step][i][p] = dp[step][i][p] + grid[i][j] + grid[p][q];
                            } else {
                                dp[step][i][p] = dp[step][i][p] + grid[i][j];
                            }
                        }
                    }

                }
            }
        }
        return dp[2 * n - 2][n - 1][n - 1] == -1 ? 0 : dp[2 * n - 2][n - 1][n - 1];
    }
}
// @lc code=end
