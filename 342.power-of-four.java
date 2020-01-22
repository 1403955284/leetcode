/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        return (num>0)&&((num & (num-1))==0)&&(num%3==1);
    }
}
// @lc code=end

