/*
 * @lc app=leetcode id=832 lang=java
 *
 * [832] Flipping an Image
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans[i][j] = A[i][M - 1 - j] == 1 ? 0 : 1;
            }
        }
        return ans;
    }
}
// @lc code=end
