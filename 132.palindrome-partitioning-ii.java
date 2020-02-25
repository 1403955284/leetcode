import java.util.Arrays;

/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        // 从i到j是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 从0到i的最小回文分割数
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ans[i] = j == 0 ? 0 : Math.min(ans[i], ans[j - 1] + 1);
                }
            }
        }
        return ans[s.length() - 1];
    }
}
// @lc code=end
