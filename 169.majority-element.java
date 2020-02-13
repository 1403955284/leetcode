/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // ================ 摩尔投票法 =================
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count != 0) {
                count += nums[i] == cur ? 1 : -1;
            } else {
                cur = nums[i];
                count++;
            }
        }
        return cur;
    }
}
// @lc code=end
