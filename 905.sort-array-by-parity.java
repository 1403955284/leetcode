/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < A.length && j >= 0 && i < j) {
            if (A[i] % 2 == 0 && A[j] % 2 == 0) {
                i++;
            } else if (A[i] % 2 != 0 && A[j] % 2 != 0) {
                j--;
            } else if (A[i] % 2 != 0 && A[j] % 2 == 0) {
                A[i] = A[i] + A[j];
                A[j] = A[i] - A[j];
                A[i] = A[i] - A[j];
                i++;
                j--;
            } else {
                i++;
                j--;
            }
        }
        return A;
    }
}
// @lc code=end
