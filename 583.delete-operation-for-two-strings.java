/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        // dp[i][j]标示word1从0到i和word2从0到j的最长公共序列长度
        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;
        for (int i = 1; i < word1.length(); i++) {
            dp[i][0] = Math.max(dp[i - 1][0], word1.charAt(i) == word2.charAt(0) ? 1 : 0);
        }
        for (int j = 1; j < word2.length(); j++) {
            dp[0][j] = Math.max(dp[0][j - 1], word1.charAt(0) == word2.charAt(j) ? 1 : 0);
        }

        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return (word1.length() - dp[word1.length() - 1][word2.length() - 1])
                + (word2.length() - dp[word1.length() - 1][word2.length() - 1]);
    }
}
// @lc code=end
