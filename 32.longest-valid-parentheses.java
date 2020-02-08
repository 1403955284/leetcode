import java.util.Stack;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        // // ======================== 动态规划做法 =======================
        // int ans = 0;
        // // 以索引i结尾的子字符串的最长有效长度
        // int[] dp = new int[s.length()];
        // for (int i = 1; i < s.length(); i++) {
        // Character cur = s.charAt(i);
        // if (cur == ')') {
        // if (s.charAt(i - 1) == '(') {
        // dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
        // } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
        // dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        // }
        // ans = Math.max(ans, dp[i]);
        // }
        // }
        // return ans;
        // // ==============================================================

        // =================参考:https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/========
        // =========方法四==========
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            }
            if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return ans;
    }
}
// @lc code=end
