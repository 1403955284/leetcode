/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int left = 0, right = len - 1, resIndex = len - 1;
        while (left <= right) {
            if (A[left] * A[left] <= A[right] * A[right]) {
                res[resIndex--] = A[right] * A[right];
                right--;
            } else {
                res[resIndex--] = A[left] * A[left];
                left++;
            }
        }
        return res;
    }
}
// @lc code=end
