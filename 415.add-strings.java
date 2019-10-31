/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length() - 1;
        int m = num2.length() - 1;
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while (n >= 0 && m >= 0) {
            int cur = add + (num1.charAt(n) - '0') + (num2.charAt(m) - '0');
            add = cur / 10;
            ans.append(cur % 10);
            // System.out.println("①ans:"+ans);
            n--;
            m--;
        }

        while (add != 0 && n >= 0) {
            int cur = add + (num1.charAt(n) - '0');
            add = cur / 10;
            ans.append(cur % 10);
            n--;
        }

        while (add != 0 && m >= 0) {
            int cur = add + (num2.charAt(m) - '0');
            add = cur / 10;
            ans.append(cur % 10);
            m--;
        }
        // System.out.println("②ans:"+ans);
        if (add != 0) {
            ans.append(add);
        }
        while (n >= 0) {
            ans.append(num1.charAt(n--));
        }
        while (m >= 0) {
            ans.append(num2.charAt(m--));
        }
        return ans.reverse().toString();
    }
}
// @lc code=end
