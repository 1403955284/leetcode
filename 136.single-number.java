/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int cur:nums){
            ans = ans^cur;
        }
        return ans;
    }
}
// @lc code=end

