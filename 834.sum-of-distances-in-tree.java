import java.util.Arrays;

/*
 * @lc app=leetcode id=834 lang=java
 *
 * [834] Sum of Distances in Tree
 */

// @lc code=start
class Solution {
    // 4 [[1,2],[3,2],[3,0]]
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] dist = new int[N][N];
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], 9999);
            dist[i][i] = 0;
        }
        for (int[] cur : edges) {
            dist[cur[0]][cur[1]] = 1;
            dist[cur[1]][cur[0]] = 1;

        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (j != i) {
                    ans[i] += dist[i][j];
                }
            }
        }
        return ans;
    }
}
// @lc code=end
