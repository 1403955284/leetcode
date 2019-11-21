/*
 * @lc app=leetcode id=650 lang=java
 *
 * [650] 2 Keys Keyboard
 */

// @lc code=start
class Solution {
    private int ans = Integer.MAX_VALUE;

    public int minSteps(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        helper(n, 1, 1, 1);
        return ans;
    }

    public void helper(int target, int curLength, int curCopyLength, int curAns) {
        if (target == curLength) {
            ans = Math.min(ans, curAns);
            return;
        }
        if (target < curLength) {
            return;
        }
        helper(target, curLength + curCopyLength, curCopyLength, curAns + 1);
        if (curLength > curCopyLength) {
            helper(target, curLength, curLength, curAns + 1);
        }
    }
}
// @lc code=end
