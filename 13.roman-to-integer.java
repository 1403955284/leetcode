/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int[] binary = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] chars = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        String tmp;
        int index = 0, end = 0;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            tmp = chars[i];
            end = index + tmp.length();

            while (end <= s.length() && s.substring(index, end).equals(tmp)) {
                sum += binary[i];
                index = end;
                end = index + tmp.length();
            }
        }
        return sum;
    }
}
// @lc code=end
