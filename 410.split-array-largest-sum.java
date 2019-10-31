/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        // 将原数组的前i个分成j分时获得的最小的最大值
        int[][] dp = new int[nums.length + 1][m + 1];
        int[] save = new int[nums.length + 1];
        // 前n个数的和
        for (int i = 0; i < nums.length; i++) {
            save[i + 1] = save[i] + nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], save[i] - save[k]));
                }
            }
        }
        return dp[nums.length][m];
    }
}
// @lc code=end
