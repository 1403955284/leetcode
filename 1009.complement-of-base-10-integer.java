/*
 * @lc app=leetcode id=1009 lang=java
 *
 * [1009] Complement of Base 10 Integer
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int N) {
        // 找到第一个大于N且为2的次方得数,将该数减1使之二进位每位都为1,反码即是N与该数的异或
        int num = 1;
        while (num <= N) {
            num <<= 1;
        }
        return N ^ (num == 1 ? 1 : (num - 1));
    }
}
// @lc code=end
