/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0;i<dp.length;i++){
            dp[i][i] = true;
        }
        for(int i =0;i<dp.length-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
            }else{
                dp[i][i+1] = false;
            }
        }
        for(int i = 2;i<s.length();i++){
            for(int j = 0;i+j<s.length();j++){
                dp[j][j+i] = dp[j+1][j+i-1]&&(s.charAt(j)==s.charAt(j+i));
            }
        }
        String ans = new String();
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp.length;j++){
                if(dp[i][j]&&(j-i+1)>ans.length()){
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

