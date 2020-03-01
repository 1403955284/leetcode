/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return 1;
        }
        // 编号为i的人信任多少人
        int[] A = new int[N + 1];
        // 编号为i的人被多少人信任
        int[] B = new int[N + 1];
        for (int[] cur : trust) {
            A[cur[0]]++;
            B[cur[1]]++;
        }
        int count = 0;
        int ans = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == N - 1 && A[i] == 0) {
                ans = i;
                count++;
            }
        }
        return count == 1 ? ans : -1;
    }
}
// @lc code=end
