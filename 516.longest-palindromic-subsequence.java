/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        // 从i到j的子串中，最长回文序列的长度
        int[][] dp = new int[s.length()][s.length()];
        // 要从后向前遍历，保证后遍历到的子问题其父问题都已完成
        for(int i = s.length()-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j = i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
// @lc code=end

