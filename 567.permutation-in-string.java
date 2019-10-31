import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        int maxLeft = 0;
        int minRight = 0;
        int ans = Integer.MAX_VALUE;
        for (char cur : s1.toCharArray()) {
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        for (right = 0; right < s2.length(); right++) {
            if (map.containsKey(s2.charAt(right))) {
                count = map.get(s2.charAt(right)) > 0 ? count + 1 : count;
                map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
            }
            while (count == s1.length()) {
                if (right - left < ans) {
                    maxLeft = left;
                    minRight = right;
                    ans = right - left + 1;
                }
                char cur = s2.charAt(left);
                if (map.containsKey(cur)) {
                    if (map.get(cur) == 0) {
                        count--;
                    }
                    map.put(cur, map.get(cur) + 1);
                }
                left++;
            }
        }
        System.out.println(maxLeft);
        System.out.println(minRight);
        System.out.println(ans);

        return ans == s1.length();
    }
}
// @lc code=end
