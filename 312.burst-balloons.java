/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        // 从i到j能取得的最大数,为了方便统一，均不包含边界点i和j;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int i = 0, j = 1; i < nums.length; i++, j++) {
            newNums[j] = nums[i];
        }
        for (int des = 2; des < nums.length + 2; des++) {
            for (int i = 0; i + des < nums.length + 2; i++) {
                int j = i + des;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + newNums[i] * newNums[k] * newNums[j] + dp[k][j]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }
}
// @lc code=end
