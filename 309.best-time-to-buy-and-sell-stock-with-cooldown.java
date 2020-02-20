/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int sell = 0;
        int rest = 0;
        int lastsell = 0;
        for (int i = 0; i < length - 1; i++) {
            lastsell = sell;
            sell = Math.max(sell + prices[i + 1] - prices[i], rest);
            rest = Math.max(lastsell, rest);
        }
        return Math.max(sell, rest);
    }
}
// @lc code=end
