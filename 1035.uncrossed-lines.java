/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[lenA][lenB];
    }
}
// @lc code=end
