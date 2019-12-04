/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int cur:nums){
            sum+=cur;
            count++;
        }
        for(int i = 0;i<=count;i++){
            sum-=i;
        }
        return -sum;
    }
}
// @lc code=end

