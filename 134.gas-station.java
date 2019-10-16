/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    /**
     * 153ms beats 5.46%
     * 
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null | gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int length = gas.length;
        int ans = -1;
        for (int i = 0; i < length; i++) {
            if (canTravel(gas, cost, i)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public boolean canTravel(int[] gas, int[] cost, int start) {
        int remain = 0;
        int curStart = start;
        do {
            remain = remain + gas[curStart] - cost[curStart];
            curStart = (curStart + 1) % gas.length;
        } while (remain > 0 && curStart != start);
        return remain >= 0 && curStart == start;
    }
}
// @lc code=end
