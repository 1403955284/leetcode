/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        /**
         * 可以将数组看成两部分 P,N 其中P的和取正号，N的和取负号; 则 sum(P)-sum(N) = target;
         * sum(P)+sum(N)+sum(P)-sum(N) = sum(nums)+target; 2*sum(P) = target+sum(nums)
         * 因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
         */
        int sum = 0;
        for (int cur : nums) {
            sum += cur;
        }
        if (S > sum || (S + sum) % 2 != 0) {
            return 0;
        }
        int target = (S + sum) / 2;
        // 到达数字和 i一共有多少种方式
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
// @lc code=end
