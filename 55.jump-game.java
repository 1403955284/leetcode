/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // // ================ 暴力 O(n^2) ====================
        // boolean[] arrive = new boolean[nums.length];
        // arrive[0] = true;
        // for (int i = 0; i < nums.length; i++) {
        // if (arrive[i]) {
        // for (int j = i; j < nums.length && j <= i + nums[i]; j++) {
        // arrive[j] = true;
        // }
        // }
        // }
        // return arrive[nums.length - 1];
        // // =================================================

        // ======================== 贪心 O(n) ===================
        /**
         * 每次都尝试去找当前能跳到的最远的距离，一旦发现最远距离小于当前索引了就返回false; 关键想法:如果一个位置能够到达，那么这个位置左侧所有位置都能到达
         */

        // 当前能到达的最远距离
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
        // ======================================================

    }
}
// @lc code=end
