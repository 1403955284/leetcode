/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 1;
        while (left < nums.length && right < nums.length) {
            if (nums[left] == 0) {
                while (right < nums.length - 1 && nums[right] == 0) {
                    right++;
                }
                swap(nums, left, right);
            }
            left++;
            right++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
// @lc code=end
