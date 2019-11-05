/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // i个0和j个1时能获得的最大个数
        int[][] dp = new int[m + 1][n + 1];
        for (String cur : strs) {
            int count0 = count(cur, '0');
            int count1 = count(cur, '1');
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= count0 && j >= count1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                        // System.out.println("count0:"+count0+" count1:"+count1+"      dp[" + i + "][" + j + "]:" + dp[i][j]);
                    }
                }
            }
        }

        return dp[m][n];
    }

    public int count(String cur, char target) {
        int ans = 0;
        for (char tmp : cur.toCharArray()) {
            if (tmp == target) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
