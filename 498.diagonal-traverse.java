/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] ans = new int[n * m];
        ans[0] = matrix[0][0];
        int index = 1;
        boolean flag = true;
        for (int k = 1; k <= n + m - 2; k++) {
            int x = 0;
            int y = 0;
            if (flag) {
                x = 0;
                y = k;
                while (y >= m) {
                    y--;
                    x++;
                }
                while (x >= n) {
                    x--;
                    y++;
                }
                while(x<n&&y>=0){
                    ans[index++] = matrix[x++][y--];
                }
                flag = false;
            } else {
                x = k;
                y = 0;
                while (y >= m) {
                    y--;
                    x++;
                }
                while (x >= n) {
                    x--;
                    y++;
                }
                while(y<m&&x>=0){
                    ans[index++] = matrix[x--][y++];
                }
                flag = true;
            }
        }
        return ans;
    }
}
// @lc code=end
