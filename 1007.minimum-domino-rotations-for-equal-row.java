/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // 记录每个数字的出现次数
        int[] count = new int[7];
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (A[i] == B[i]) {
                count[A[i]]++;
            } else {
                count[A[i]]++;
                count[B[i]]++;
            }
        }
        int target = -1;
        for (int i = 1; i <= 6; i++) {
            if (count[i] == length) {
                target = i;
            }
        }
        if (target == -1) {
            return -1;
        }
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] != target) {
                ans1++;
            }
            if (B[i] != target) {
                ans2++;
            }
        }
        return Math.min(ans1, ans2);
    }
}
// @lc code=end
