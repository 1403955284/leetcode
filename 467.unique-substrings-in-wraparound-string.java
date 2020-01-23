
/*
 * @lc app=leetcode id=467 lang=java
 *
 * [467] Unique Substrings in Wraparound String
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        // // ============================ O(n^2) 超时 ==============================
        // if(p==null||p.length()==0){
        //     return 0;
        // }
        // // 从i到j(包含j)的子串是否包含在S中
        // boolean[][] dp = new boolean[p.length()][p.length()];
        // Set<String> set = new HashSet<>();
        // for(int i = 0;i<dp.length;i++){
        //     dp[i][i] = true;
        //     set.add(p.substring(i, i+1));
        // }
        // for(int i = 0;i<dp.length;i++){
        //     for(int j = i+1;j<dp.length;j++){
        //         dp[i][j] = dp[i][j-1]
        //                 &&
        //                 (p.charAt(j)-p.charAt(j-1)==1
        //                  ||(p.charAt(j-1)=='z'&&p.charAt(j)=='a'));
        //                  if(dp[i][j]){
        //                      set.add(p.substring(i, j+1));
        //                  }
        //     }
        // }
        // return set.size();
        // // ===========================================================================


        

        // ====================================== O(n) ===================================
        // 以i结尾的子串的最大长度
        int[] dp = new int[26];
        int curMax = 0;
        int ans = 0;
        for(int i = 0;i<p.length();i++){
            if(i>0&&(p.charAt(i)-p.charAt(i-1)==1||p.charAt(i-1)=='z'&&p.charAt(i)=='a')){
                curMax++;
            }else{
                curMax = 1;
            }
            int index = p.charAt(i)-'a';
            dp[index] = Math.max(dp[index], curMax);
        }
        for(int i=0;i<dp.length;i++){
            ans+=dp[i];
        }
        return ans;
    }
}
// @lc code=end

