/*
 * @lc app=leetcode id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        // 以下标i对应的元素结尾的最长连续递增子数组的长度
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;
        }
        for(int i = 1;i<nums.length;i++){
            int j = i-1;
            if(nums[j]<nums[i]){
                dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if(dp[i]>ans){
                ans = dp[i];
            }
        }
        return ans;
    }
}
// @lc code=end

