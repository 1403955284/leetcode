/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            int cur = 1;
            int j = nums[i];
            while(j!=i){
                cur++;
                j = nums[j];
            }
            ans = ans>=cur?ans:cur;
        }
        return ans;
    }
}
// @lc code=end

