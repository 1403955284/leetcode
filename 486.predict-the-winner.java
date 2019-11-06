/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        // dp[i][j] 表示从i到j先手拿比后手拿能多拿的分数
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i][i] = nums[i];
        }
        for(int i = nums.length-1;i>=0;i--){
            for(int j = i+1;j<nums.length;j++){
                // 对于每个扩大的边界，如果player1选择取这个值，则在边界内本来是
                // 1先手拿能比2多拿的分数就变成了1后手拿比2少拿的分数，即 -dp[i+1][j]是1后手拿比2多拿的分数
                // 即边界的值i j 如果1选择去拿i，则他会丢失之前在 i+1到j拿到的优势，反而变成劣势
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }
}
// @lc code=end

