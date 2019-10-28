/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int target = 0;
        for (int cur : nums) {
            target += cur;
        }
        if(target%4!=0){
            return false;
        }
        return dfs(nums, 0, target / 4, 0, 0, 0, 0);
    }

    public boolean dfs(int[] nums, int index, int target, int a, int b, int c, int d) {
        if (a <= target && b <= target && c <= target && d <= target) {
            if (index == nums.length) {
                if (a == b && a == c && a == d) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return dfs(nums, index + 1, target, a + nums[index], b, c, d)
                        || dfs(nums, index + 1, target, a, b + nums[index], c, d)
                        || dfs(nums, index + 1, target, a, b, c + nums[index], d)
                        || dfs(nums, index + 1, target, a, b, c, d + nums[index]);
            }
        } else {
            return false;
        }
    }
}
// @lc code=end
