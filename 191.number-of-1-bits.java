/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        // // ======================================
        // for (int i = 0; i < 32; i++) {
        // // 如果左移一位再右移一位之后与原来不相等，说明该位为1
        // if ((n >>> 1) << 1 != n) {
        // count++;
        // }
        // n >>>= 1;
        // }
        // // ========================================

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }

        return count;
    }
}
// @lc code=end
