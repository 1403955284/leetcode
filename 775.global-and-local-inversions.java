/*
 * @lc app=leetcode id=775 lang=java
 *
 * [775] Global and Local Inversions
 */

// @lc code=start
class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] < i - 1 || A[i] > i + 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
