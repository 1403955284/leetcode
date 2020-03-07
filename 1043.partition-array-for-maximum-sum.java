/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        // A中索引为i的数之前的子数组的最大和
        int[] dp = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            int curMax = A[i - 1];
            for (int j = i - 1, k = 1; j >= 0 && k <= K; j--, k++) {
                curMax = Math.max(curMax, A[j]);
                dp[i] = Math.max(dp[i], dp[j] + curMax * k);
            }
        }
        return dp[A.length];
    }
}
// @lc code=end
