/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 */

// @lc code=start
class Solution {
    public boolean rotateString(String A, String B) {
        // // ========================== O(n^2) ==========================
        // if (A.isEmpty() && B.isEmpty()) {
        // return true;
        // }
        // if (A.length() != B.length()) {
        // return false;
        // }
        // int length = A.length();
        // for (int i = 0; i < length; i++) {
        // StringBuilder sb = new StringBuilder();
        // int index = i;
        // for (int j = 0; j < length; index++, j++) {
        // sb.append(A.charAt((index + length) % length));
        // }
        // if (B.equals(sb.toString())) {
        // return true;
        // }
        // }
        // return false;
        // // ===========================================================

        // ============================ KMP ===============================
        // 查看A+A串中是否包含B串
        if (A.length() != B.length()) {
            return false;
        }
        if (A.isEmpty()) {
            return true;
        }
        String txt = A + A;
        String pat = B;
        int[] next = new int[pat.length()];

        // pat长度为1的情况下，next只有一个-1
        if (pat.length() == 1) {
            next[0] = -1;
        } else {
            next[0] = -1;
            next[1] = 0;
            int pos = 2;
            // 填充next数组

            // cn表示一直表示当前pos前一个索引位置(pos-1)所对应的next值，不管上次遍历中处理了几次 cn = next[cn]

            // int cn = 0;
            // while (pos < next.length) {
            // if (pat.charAt(pos - 1) == pat.charAt(cn)) {
            // next[pos++] = ++cn;
            // } else if (cn > 0) {
            // cn = next[cn];
            // } else {
            // next[pos++] = 0;
            // }
            // }

            // 上面的解法中cn的处理无法理解，自行改为下面的方式
            for (int i = pos; i < next.length; i++) {
                int cn = next[pos - 1];
                while (cn >= 0 && pat.charAt(i - 1) != pat.charAt(cn)) {
                    cn = next[cn];
                }
                if (cn < 0) {
                    next[pos] = 0;
                } else if (pat.charAt(i - 1) != pat.charAt(cn)) {
                    next[pos] = next[cn] + 1;
                }
            }
        }
        // 尝试匹配
        int ti = 0;
        int pi = 0;
        while (ti < txt.length() && pi < pat.length()) {
            if (txt.charAt(ti) == pat.charAt(pi)) {
                ti++;
                pi++;
            } else if (next[pi] == -1) {
                ti++;
            } else {
                pi = next[pi];
            }
        }
        return pi == pat.length();
    }
}
// @lc code=end
