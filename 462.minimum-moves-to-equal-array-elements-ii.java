import java.util.Arrays;

/*
 * @lc app=leetcode id=462 lang=java
 *
 * [462] Minimum Moves to Equal Array Elements II
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int target = nums[n/2];
        for(int cur:nums){
            ans+=Math.abs(cur-target);
        }
        return ans;
    }
}
// @lc code=end

