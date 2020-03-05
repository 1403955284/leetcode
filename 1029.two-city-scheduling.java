import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] - a[1]) - (b[0] - b[1]);
            }
        });
        int ans = 0, len = costs.length;
        for (int i = 0; i < len; i++) {
            ans += costs[i][i < len / 2 ? 0 : 1];
        }
        return ans;
    }
}
// @lc code=end
