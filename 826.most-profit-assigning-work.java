/*
 * @lc app=leetcode id=826 lang=java
 *
 * [826] Most Profit Assigning Work
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        for(int cur:worker){
            int curProfit = 0;
            for(int i = difficulty.length-1;i>=0;i--){
                if(cur>=difficulty[i]){
                    curProfit = Math.max(curProfit, profit[i]);
                }
            }
            ans+=curProfit;
        }
        return ans;
    }
}
// @lc code=end

