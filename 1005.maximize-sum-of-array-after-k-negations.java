/*
 * @lc app=leetcode id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            int curMinIndex = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] < A[curMinIndex]) {
                    curMinIndex = j;
                }
            }
            A[curMinIndex] = -A[curMinIndex];
        }
        int ans = 0;
        for (int cur : A) {
            ans += cur;
        }
        return ans;
    }
}
// @lc code=end
