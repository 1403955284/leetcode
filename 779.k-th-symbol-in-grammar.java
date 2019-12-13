/*
 * @lc app=leetcode id=779 lang=java
 *
 * [779] K-th Symbol in Grammar
 */

// @lc code=start
class Solution {
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K-1)&1;
    }
}
// @lc code=end

