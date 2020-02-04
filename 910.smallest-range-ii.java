import java.util.Arrays;

/*
 * @lc app=leetcode id=910 lang=java
 *
 * [910] Smallest Range II
 */

// @lc code=start
class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        int ans = max - min;
        // 在该点之前得数全部减K，该点之后(包括该点)全部加K
        for (int i = 1; i < A.length; i++) {
            int curMax = Math.max(max - K, A[i - 1] + K);
            int curMin = Math.min(A[i] - K, min + K);
            ans = Math.min(ans, curMax - curMin);
        }
        return ans;
    }
}
// @lc code=end
