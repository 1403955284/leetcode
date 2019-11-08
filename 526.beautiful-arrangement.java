import java.util.Arrays;

/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    private int ans = 0;

    public int countArrangement(int N) {
        int[] nums = new int[N + 1];
        // 所有当前可用的插入位置都标记为-1
        Arrays.fill(nums, -1);
        helper(nums, 1, N);
        return ans;
    }

    public void helper(int[] nums, int n, int N) {
        if (n > N) {
            ans++;
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] == -1) && (i % n == 0 || n % i == 0)) {
                nums[i] = n;
                helper(nums, n + 1, N);
                // 回溯
                nums[i] = -1;
            }
        }
    }
}
// @lc code=end
