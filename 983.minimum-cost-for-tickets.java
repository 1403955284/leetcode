/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // 旅行到第i天所需要的花费(i是days中的值)
        int[] dp = new int[366];
        int index = 0;
        for (int i = 1; i <= 365 && index < days.length; i++) {
            if (days[index] != i) {
                dp[i] = dp[i - 1];
                continue;
            }
            index++;
            int cost1 = dp[i - 1] + costs[0];
            int cost2 = i - 7 >= 0 ? dp[i - 7] + costs[1] : costs[1];
            int cost3 = i - 30 >= 0 ? dp[i - 30] + costs[2] : costs[2];
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }
        return dp[days[days.length - 1]];
    }
}
// @lc code=end
