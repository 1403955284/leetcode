/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // // ========================== 5% ========================
        // int ans = nums[0];
        // // 以i结尾的连续子序列的最大乘积
        // int[] dp = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // dp[i] = nums[i];
        // }
        // for (int i = 1; i < nums.length; i++) {
        // int cur = nums[i];
        // for (int j = i - 1; j >= 0; j--) {
        // cur *= nums[j];
        // dp[i] = Math.max(dp[i], cur);
        // }
        // ans = Math.max(ans, dp[i]);
        // }
        // return ans;
        // // =====================================================

        // =========================== O(n) 答案 ================

        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                imax = imax + imin;
                imin = imax - imin;
                imax = imax - imin;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
        // =====================================================
    }
}
// @lc code=end
