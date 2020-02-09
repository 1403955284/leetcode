/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (Character cur : s.toCharArray()) {
            if (cur >= 'a' && cur <= 'z' || cur >= '0' && cur <= '9') {
                sb.append(cur);
                tmp.append(cur);
            }
        }
        return sb.reverse().toString().equals(tmp.toString());
    }
}
// @lc code=end
