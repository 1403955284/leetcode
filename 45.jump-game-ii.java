/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 到i的最少步数
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;


        // 超时
        // for (int i = 1; i < nums.length; i++) {
        // for (int j = 0; j < i; j++) {
        // int maxStep = nums[j];
        // if (i - j <= maxStep) {
        // dp[i] = Math.min(dp[i], dp[j] + 1);
        // }
        // }
        // }


        // 另一种想法，每次到达一个点，就将从它能到达的点对应的dp[i+j]更新
        // 减少了第二重遍历的数量
        for (int i = 0; i < nums.length - 1; i++) {
            int cutMax = nums[i];
            for (int j = 0; j <= cutMax && (i + j) < nums.length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];



        // // ==================== 答案做法 O(N) =======================

        // int curEnd = 0;
        // int curMax = 0;
        // int jumpTimes = 0;
        // for(int i = 0;i<nums.length-1;i++){
        //     curMax = Math.max(curMax, i+nums[i]);
        //     if(i==curEnd){
        //         jumpTimes++;
        //         curEnd = curMax;
        //     }
        // }
        // return jumpTimes;

        // // ========================================================
    }
}
// @lc code=end
