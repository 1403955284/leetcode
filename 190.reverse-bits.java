
/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    public int reverseBits(int n) {
        String target = Integer.toBinaryString(n);
        System.out.print(target);
        StringBuilder stringBuilder = new StringBuilder(target);
        stringBuilder.reverse();
        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
// @lc code=end

