/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = 0;
        for (int cur : nums) {
            target += cur;
        }
        if (k > target || target % k != 0) {
            return false;
        }
        target /= k;
        boolean[] used = new boolean[nums.length];
        return backtrack(target, 0, k, 0, used, nums);

    }

    public boolean backtrack(int target, int cur, int k, int start, boolean[] used, int[] nums) {
        if (k == 0) {
            return true;
        }
        if (cur == target) {
            return backtrack(target, 0, k - 1, 0, used, nums);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= target) {
                used[i] = true;
                if (backtrack(target, cur + nums[i], k, start + 1, used, nums)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    
}
// @lc code=end
