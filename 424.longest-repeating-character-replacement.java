/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int[] times = new int[26];
        int ans = Integer.MIN_VALUE;
        int curMax = Integer.MIN_VALUE;
        while (right < s.length()) {
            times[s.charAt(right) - 'A']++;
            curMax = Math.max(curMax, times[s.charAt(right) - 'A']);
            if ((right - left + 1) - curMax > k) {
                times[s.charAt(left++) - 'A']--;
            }
            ans = Math.max(ans, (right - left + 1));
            right++;

        }
        return ans;
    }
}
// @lc code=end
