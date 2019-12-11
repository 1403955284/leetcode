/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for(int cur:nums){
            max = Math.max(max, cur);
        }
        int[] count = new int[max+1];
        int[] dp = new int[max+1];
        for(int cur:nums){
            count[cur]++;
        }
        dp[1] = count[1];
        dp[2] = Math.max(dp[1], 2*count[2]);
        for(int i = 3;i<=max;i++){
            dp[i] = Math.max(dp[i-1], i*count[i]+dp[i-2]);
        }
        return dp[max];
    }
}
// @lc code=end

