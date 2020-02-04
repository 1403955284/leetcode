import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] A) {
        // 参考:https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C%2B%2BJavaPython-Stack-Solution
        int temp = 1_000_000_000 + 7;
        int ans = 0;
        // A中索引为i的数字的左边有多少个连续大于A[i]的数字，至少有一个，为其本身。
        int[] left = new int[A.length];
        // A中索引为i的数字的右边有多少个连续大于或等于A[i]的数字，至少有一个，为其本身。
        int[] right = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            int j = i - 1;
            while (j >= 0 && A[j] > A[i]) {
                count += left[j];
                j -= left[j];
            }
            left[i] = count;
            // System.out.println("left[" + i + "]:" + left[i]);
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int count = 1;
            int j = i + 1;
            while (j < A.length && A[j] >= A[i]) {
                count += right[j];
                j += right[j];
            }
            right[i] = count;
            // System.out.println("right[" + i + "]:" + right[i]);
        }

        for (int i = 0; i < A.length; i++) {
            ans = (ans + A[i] * left[i] * right[i]) % temp;
        }
        return ans;
    }
}
// @lc code=end
