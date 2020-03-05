/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Sequence
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        // 以i结尾公差为j的等差子序列的长度,为了避免公差为负数，扩展至20001
        int[][] dp = new int[A.length][20001];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int distance = A[i] - A[j] + 10000;
                if (dp[j][distance] > 0) {
                    dp[i][distance] = Math.max(dp[i][distance], dp[j][distance] + 1);
                } else {
                    dp[i][distance] = 2;
                }
                ans = Math.max(ans, dp[i][distance]);
            }
        }
        return ans;
    }
}
// @lc code=end
