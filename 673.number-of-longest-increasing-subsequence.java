/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        // 以下标i对应元素结尾的递增子序列的最大长度
        int[] dp = new int[nums.length];
        // 以下标i对应的元素结尾的递增子序列的最大个数
        int[] counts = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;
            counts[i] = 1;
        }
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            // System.out.println("dp["+i+"]:"+dp[i]+"  counts["+i+"]:"+counts[i]);
        }

        for(int i = 0;i<dp.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        for(int i = 0;i<dp.length;i++){
            if(dp[i]==max){
                ans+=counts[i];
            }
        }
        return ans;


    }
}
// @lc code=end

