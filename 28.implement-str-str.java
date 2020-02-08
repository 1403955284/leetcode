import java.util.HashMap;

/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        // ================== 利用KMP =============
        int[] next = new int[needle.length()];
        if (needle.length() == 1) {
            next[0] = -1;
        } else {
            next[0] = -1;
            next[1] = 0;
            int pos = 2;
            int cn = 0;
            while (pos < next.length) {
                if (needle.charAt(pos - 1) == needle.charAt(cn)) {
                    next[pos++] = ++cn;
                } else if (cn > 0) {
                    cn = next[cn];
                } else {
                    next[pos++] = 0;
                }
            }
        }
        // 尝试匹配
        int ti = 0;
        int pi = 0;
        while (ti < haystack.length() && pi < needle.length()) {
            if (haystack.charAt(ti) == needle.charAt(pi)) {
                ti++;
                pi++;
            } else if (next[pi] == -1) {
                ti++;
            } else {
                pi = next[pi];
            }
        }
        return pi == needle.length() ? ti - pi : -1;
    }
}
// @lc code=end
