import java.util.Arrays;

/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 到i点经过j步的最小距离
        int[][] dp = new int[n][K+2];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Arrays.fill(dp[src], 0);

        for(int k =1;k<=K+1;k++){
            for(int[] cur:flights){
                int curSrc = cur[0];
                int curDst = cur[1];
                int curLength = cur[2];
                if(dp[curSrc][k-1]!=Integer.MAX_VALUE){
                    dp[curDst][k] = Math.min(dp[curDst][k], dp[curSrc][k - 1] + curLength);
                }
            }
        }
        return dp[dst][K+1]==Integer.MAX_VALUE?-1:dp[dst][K+1];
    }
}
// @lc code=end

