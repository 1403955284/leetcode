/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // =============================== 答案方法,只用一个for
        // =====================================
        // // 到第i所房子所能获得的最大金额，从第一家开始
        // int[] dp = new int[nums.length + 1];
        // // 到第i所房子所能获得最大金额，从第二家开始
        // int[] dp2 = new int[nums.length + 1];
        // for (int i = 2; i <= nums.length; i++) {
        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        // dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        // }
        // return Math.max(dp[nums.length], dp2[nums.length]);
        // ===========================================================================

        // 到第i所房子所能获得的最大金额，从第一家开始
        int[] dp = new int[nums.length];
        // 到第i所房子所能获得最大金额，从第二家开始
        int[] dp2 = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp[nums.length - 2], dp2[nums.length - 1]);

    }
}
// @lc code=end
