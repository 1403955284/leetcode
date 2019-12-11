/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int ans = 0;
        int sum = 1;
        int i = 0;
        for (int j = 0;j < nums.length;j++) {
            sum *= nums[j];
            while(sum>=k){
                sum/=nums[i];
                i++;
            }
            ans += j-i+1;
        }

        return ans;
    }
}
// @lc code=end
