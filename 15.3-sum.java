import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (prev == nums[i]) {
                continue;
            }
            prev = nums[i];
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
