/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int max=amount+1;
        // 获得i块钱所需最少硬币数
        int[] dp=new int[amount+1];
        for(int i = 0;i<dp.length;i++){
            dp[i] = max;
        }
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int a:coins){
                if(i-a>=0){
                    dp[i]=Math.min(dp[i],dp[i-a]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
// @lc code=end

