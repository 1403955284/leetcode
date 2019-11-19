
import java.util.Arrays;

/*
 * @lc app=leetcode id=628 lang=java
 *
 * [628] Maximum Product of Three Numbers
 */

// @lc code=start
class Solution {
    public int maximumProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(nums);
        ans = Math.max(ans, nums[0]*nums[1]*nums[nums.length-1]);
        ans = Math.max(ans, nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
        return ans;
    }
}
// @lc code=end

