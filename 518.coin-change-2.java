import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public int change(int amount, int[] coins) {
        // // ================== 暴力解法，超时 ===================
        // if (amount == 0) {
        //     return 1;
        // }
        // for (int cur : coins) {
        //     List<Integer> tmp = new ArrayList<>();
        //     tmp.add(cur);
        //     helper(amount, cur, coins, tmp);
        // }
        // return ans.size();



        // // ==================== 动态规划做法 =======================

        // // 参考:https://leetcode-cn.com/problems/coin-change-2/solution/dong-tai-gui-hua-wan-quan-bei-bao-wen-ti-by-liweiw/ 
        
        // // 考虑前i个硬币(不包含第i个)组成j金额的组合数
        // int[][] dp = new int[coins.length+1][amount+1];
        // dp[0][0] = 1;
        // for(int i = 1;i<=coins.length;i++){
        //     for(int j = 0;j<=amount;j++){
        //         for(int k = 0;j-k*coins[i-1]>=0;k++){
        //             dp[i][j]+=dp[i-1][j-k*coins[i-1]];
        //         }
        //     }
        // }
        // return dp[coins.length][amount];
        // // ======================================================



        // ============= 动态规划优化版(减少一维) ===========

        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1;i<=coins.length;i++){
            for(int j = 0;j<=amount;j++){
                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1]>=0){
                    dp[i][j]+=dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];

        // ===============================================
    }

    public void helper(int target, int cur, int[] coins, List<Integer> tmp) {
        if (cur == target) {
            Collections.sort(tmp);
            if (!ans.contains(tmp)) {
                ans.add(tmp);
            }
            return;
        }
        for (int coin : coins) {
            if (cur + coin <= target) {
                List<Integer> list = new ArrayList<>(tmp);
                list.add(coin);
                helper(target, cur + coin, coins, list);
            }
        }
    }
}
// @lc code=end
