import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=1030 lang=java
 *
 * [1030] Matrix Cells in Distance Order
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[index][0] = i;
                ans[index++][1] = j;
            }
        }
        Arrays.sort(ans, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0)) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
            }
        });
        return ans;
    }
}
// @lc code=end
