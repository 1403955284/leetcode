import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        // 需要出现的字母及其需要出现的次数
        for (char cur : t.toCharArray()) {
            map.put(cur, map.containsKey(cur) ? map.get(cur) + 1 : 1);
        }
        int count = 0;
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        for (right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                count = map.get(cur) > 0 ? count + 1 : count;
                // 该字母需要出现的次数减一
                map.put(cur, map.get(cur) - 1);
            }
            while (count == t.length()) {
                if (right - left < ans) {
                    ans = right - left;
                    minLeft = left;
                    minRight = right;
                }
                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    // 该字母以达到所需要出现的次数要求
                    if (map.get(c) == 0) {
                        count--;
                    }
                    map.put(c, map.get(c) + 1);
                }
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }
}
// @lc code=end
