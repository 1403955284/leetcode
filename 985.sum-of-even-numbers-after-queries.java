/*
 * @lc app=leetcode id=985 lang=java
 *
 * [985] Sum of Even Numbers After Queries
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int sum = 0;
        for (int cur : A) {
            if (cur % 2 == 0) {
                sum += cur;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                ans[i] = (val + A[index]) % 2 == 0 ? sum + val : sum - A[index];
            } else {
                ans[i] = (val + A[index]) % 2 == 0 ? sum + val + A[index] : sum;
            }
            A[index] = val + A[index];
            sum = ans[i];
        }
        return ans;
    }
}
// @lc code=end
