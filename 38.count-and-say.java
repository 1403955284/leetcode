/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev;
        // 个数
        int count;
        // 当前记录的数字
        char curNum;
        for (int i = 1; i < n; i++) {
            prev = cur;
            count = 1;
            curNum = prev.charAt(0);
            cur = new StringBuilder();
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != curNum) {
                    cur.append(count).append(curNum);
                    count = 1;
                    curNum = prev.charAt(j);
                } else {
                    count++;
                }
            }
            cur.append(count).append(curNum);
        }
        return cur.toString();
    }
}
// @lc code=end
