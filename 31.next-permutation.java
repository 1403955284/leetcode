import java.util.Arrays;

/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
                return;
            } else {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, n);
                    for (int j = i; j < n; j++) {
                        if (nums[j] > nums[i - 1]) {
                            nums[i - 1] = nums[i - 1] + nums[j];
                            nums[j] = nums[i - 1] - nums[j];
                            nums[i - 1] = nums[i - 1] - nums[j];
                            return;
                        }
                    }
                }
            }
        }
    }
}
// @lc code=end
