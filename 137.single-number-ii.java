/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int seen_once = 0;
        int seen_twice = 0;

        for (int num : nums) {
            seen_once = ~seen_twice & (seen_once ^ num);
            seen_twice = ~seen_once & (seen_twice ^ num);
        }

        return seen_once;
    }
}
// @lc code=end
