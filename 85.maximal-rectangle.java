/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int ans = 0;
        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            sum[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                if ((matrix[i][j] - '0') != 0) {
                    sum[i][j] = sum[i - 1][j] + (matrix[i][j] - '0');
                } else {
                    sum[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                int curMin = sum[i][j];
                for (int k = j; k < sum[0].length; k++) {
                    curMin = Math.min(curMin, sum[i][k]);
                    ans = Math.max(ans, curMin * (k - j + 1));
                }
            }
        }
        return ans;
    }
}
// @lc code=end
