/*
 * @lc app=leetcode id=984 lang=java
 *
 * [984] String Without AAA or BBB
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int A, int B) {
        char addMore = A > B ? 'a' : 'b';
        char addLess = A > B ? 'b' : 'a';
        // 需要多添加字符的总个数
        int moreSum = A > B ? A : B;
        int lessSum = A > B ? B : A;
        StringBuilder ans = new StringBuilder();
        while (moreSum > 0 || lessSum > 0) {
            if (moreSum > 0) {
                moreSum--;
                ans.append(addMore);
            }
            // 尽量保证总数量多的字符多添加一次
            if (moreSum > lessSum) {
                moreSum--;
                ans.append(addMore);
            }
            if (lessSum > 0) {
                lessSum--;
                ans.append(addLess);
            }
        }
        return ans.toString();
    }
}
// @lc code=end
