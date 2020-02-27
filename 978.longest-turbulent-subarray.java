import java.util.Collections;

/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int ans = 0;
        // 0为相等，1为大于，-1为小于
        int flag = 0;
        int curLength = 0;
        for (int i = 0; i < A.length; i++) {
            if (curLength == 0) {
                curLength = 1;
            } else {
                int prev = A[i - 1];
                int cur = A[i];
                if (prev == cur) {
                    flag = 0;
                    curLength = 1;
                } else {
                    int newFlag = prev > cur ? 1 : -1;
                    curLength = newFlag == flag ? 2 : curLength + 1;
                    flag = newFlag;
                }
            }
            ans = Math.max(ans, curLength);
        }
        return ans;
    }
}
// @lc code=end
