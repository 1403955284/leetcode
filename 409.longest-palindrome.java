/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] chars = new int[100];
        int ans = 0;
        for (char cur : s.toCharArray()) {
            chars[cur - 'A']++;
        }
        for (int cur : chars) {
            if (cur % 2 == 0) {
                ans += cur;
            } else {
                // 出现次数为奇数的可以保留其偶数个加入，多的一个后面放在字符串中间
                ans += cur - 1;
            }
        }
        // 避免“bb”这种用例，会多加一个1
        return ans + 1 > s.length() ? ans : ans + 1;
    }
}
// @lc code=end
