/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return 0;
        int high = 0, low = len - 1, max = nums[0], min = nums[len - 1];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            if (nums[i] < max)
                high = i;
            if (nums[len - 1 - i] > min)
                low = len - 1 - i;
        }
        return high > low ? high - low + 1 : 0;
    }
}
// @lc code=end
