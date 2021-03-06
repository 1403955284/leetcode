import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                ans.add(Math.abs(nums[i]));
            }
        }
        return ans;
    }
}
// @lc code=end
