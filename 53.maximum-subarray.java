/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // ================== 动态规划 O(N) ====================
        int ans = nums[0];
        // 以i结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i], nums[i] + dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        // =================================================

    }
}
// @lc code=end
