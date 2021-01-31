import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=1525 lang=java
 *
 * [1525] Number of Good Ways to Split a String
 */

// @lc code=start
class Solution {
    public int numSplits(String s) {
        int[] left = new int[256];
        int[] right = new int[256];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (right[c]++ == 0) {
                count++;
            }
        }
        int l = 0;
        int ans = 0;
        int r = count;
        for (char c : s.toCharArray()) {
            if (left[c]++ == 0) {
                l++;
            }
            if (--right[c] == 0) {
                r--;
            }
            if (l == r) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
