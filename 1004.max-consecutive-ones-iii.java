/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] A, int K) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int curK = K;
        while (left <= right && right < A.length) {
            if (curK > 0 || A[right] == 1) {
                ans = Math.max(ans, right - left + 1);
                curK = A[right] == 1 ? curK : curK - 1;
                right++;
            } else if (K == 0) {
                while (right < A.length && A[right] != 1) {
                    right++;
                }
                left = right;
            } else {
                while (curK == 0) {
                    if (A[left] == 0) {
                        curK++;
                    }
                    left++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
