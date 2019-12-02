/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        for(int i = 0;i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end
