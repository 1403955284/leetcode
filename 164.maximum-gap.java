import java.util.Arrays;

/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length-1;i++){
            ans = Math.max(ans, nums[i+1]-nums[i]);
        }
        return ans;
    }
}
// @lc code=end

