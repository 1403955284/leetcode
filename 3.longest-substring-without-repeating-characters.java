import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> record = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (!record.containsKey(s.charAt(right)) || record.get(s.charAt(right)) == 0) {
                record.put(s.charAt(right), 1);
                right++;
            } else {
                ans = Math.max(ans, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    record.put(s.charAt(left), 0);
                    left++;
                }
                left++;
                right++;
            }
        }
        return Math.max(ans, right - left);
    }
}
// @lc code=end
