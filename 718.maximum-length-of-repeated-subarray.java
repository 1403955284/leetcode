import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {
        // int max = 0;
        // // 以A[i]和B[j]结尾(不包括)的数组的最长子数组长度
        // int[][] dp = new int[A.length+1][B.length+1];
        // for(int i = 0;i<=A.length;i++){
        // for(int j = 0;j<=B.length;j++){
        // if(i==0||j==0){
        // dp[0][0] = 0;
        // }else{
        // if(A[i-1]==B[j-1]){
        // dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
        // max = Math.max(max, dp[i][j]);
        // }
        // }
        // }
        // }
        // return max;

        // ====================== 2020-03-05 重写 =====================
        int[][] dp = new int[A.length][B.length];
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = A[i] == B[j] ? 1 : 0;
                } else if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;

    }
}
// @lc code=end
