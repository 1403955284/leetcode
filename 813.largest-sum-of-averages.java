/*
 * @lc app=leetcode id=813 lang=java
 *
 * [813] Largest Sum of Averages
 */

// @lc code=start
class Solution {
    private double ans = 0;

    public double largestSumOfAverages(int[] A, int K) {
        // // ========================= 超时 ===================================
        // if (A == null || A.length == 0) {
        //     return 0;
        // }
        // if (K == 1) {
        //     double sum = 0;
        //     for (int cur : A) {
        //         sum += cur;
        //     }
        //     return sum / A.length;
        // }
        // dfs(A, 0, 0, 0, K, 0, 0);
        // return ans;
        // // =================================================================

        if (K < 0) {
            return 0;
        }
        double[][] dp = new double[A.length][K+1];
        int[] sum = new int[A.length];
        int curr = 0;
        for (int i = 0; i < A.length; i++) {
            curr += A[i];
            sum[i] = curr;
        }
        
        for (int i = 0; i < A.length; i++) {
            dp[i][1] = (double)sum[i] / (double)(i + 1);
        }
        
        for (int k = 2; k <= K; k++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < i; j++) {
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (double) (sum[i] - sum[j]) / (double)(i - j));
                }
            }
        }
        
        return dp[A.length - 1][K];
    }


    // 超时
    public void dfs(int[] A, int index, double curSum, int curCount, int K, int curK, double curAns) {
        if (index == A.length) {
            return;
        }

        if (curK == K - 1) {
            // System.out.println(index+" "+curAns);
            int count = 0;
            double sum = 0;
            while (index < A.length) {
                sum += A[index++];
                count++;
            }
            curAns += sum / count;
            ans = Math.max(ans, curAns);
            return;
        }

        if (A.length - index >= K - curK-1) {
            // 继续扩充当前子序列
            dfs(A, index + 1, curSum + A[index], curCount + 1, K, curK, curAns);

            if (curCount > 0) {
                // 不再扩充当前子序列
                dfs(A, index, 0, 0, K, curK + 1, curAns + curSum / curCount);
            }
        }
    }
}
// @lc code=end
