/*
 * @lc app=leetcode id=1031 lang=java
 *
 * [1031] Maximum Sum of Two Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        // 前缀和
        int[] sum = new int[A.length];
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            sum[i] = curSum;
        }
        int ans = Integer.MIN_VALUE;
        // L在M前面
        for (int i = L - 1; i < A.length; i++) {
            int curSumL = i - L >= 0 ? sum[i] - sum[i - L] : sum[i];
            int curSumM = Integer.MIN_VALUE;

            int j = i + M;
            int prev = i;
            while (j < A.length) {
                curSumM = Math.max(curSumM, sum[j] - sum[prev]);
                j++;
                prev++;
            }
            ans = Math.max(ans, curSumL + curSumM);
        }
        // M在L前面
        for (int i = M - 1; i < A.length; i++) {
            int curSumM = i - M >= 0 ? sum[i] - sum[i - M] : sum[i];
            int curSumL = Integer.MIN_VALUE;

            int j = i + L;
            int prev = i;
            while (j < A.length) {
                curSumL = Math.max(curSumL, sum[j] - sum[prev]);
                j++;
                prev++;
            }
            ans = Math.max(ans, curSumL + curSumM);
        }
        return ans;
    }
}
// @lc code=end
