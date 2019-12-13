import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=795 lang=java
 *
 * [795] Number of Subarrays with Bounded Maximum
 */

// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R)-count(A, L-1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x: A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
}
// @lc code=end

