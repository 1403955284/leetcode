import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {

        /** dp做法 */
        // if(nums==null||nums.length==0){
        // return 0;
        // }
        // // 以i结尾的子序列的最大长度
        // int[] dp = new int[nums.length];
        // int ans = Integer.MIN_VALUE;
        // for(int i = 0;i<dp.length;i++){
        // dp[i] = 1;
        // }
        // for(int i = 0 ;i<nums.length;i++){
        // for(int j = i-1;j>=0;j--){
        // if(nums[j]<nums[i]){
        // dp[i] = Math.max(dp[i], dp[j]+1);
        // }
        // }
        // ans = Math.max(ans,dp[i]);
        // }
        // return ans;

        /** 二分查找+贪心 */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] date = new int[nums.length];
        // 长度为i+1的递增子序列的最小尾数
        date[0] = nums[0];
        int curHigh = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == date[curHigh]) {
                continue;
            }
            if (nums[i] < date[curHigh]) {
                date[search(date, nums[i], 0, curHigh)] = nums[i];
            } else {
                date[++curHigh] = nums[i];
            }
        }
        return curHigh + 1;
    }

    public int search(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                return search(nums, target, mid + 1, high);
            } else {
                return search(nums, target, low, mid - 1);
            }
        }
        return low;
    }
}
// @lc code=end
