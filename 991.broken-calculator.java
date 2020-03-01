/*
 * @lc app=leetcode id=991 lang=java
 *
 * [991] Broken Calculator
 */

// @lc code=start
class Solution {
    public int brokenCalc(int X, int Y) {
        if (X >= Y)
            return X - Y;
        if (Y % 2 == 0)
            return 1 + brokenCalc(X, Y / 2);
        else
            return 1 + brokenCalc(X, (Y + 1));
    }
}
// @lc code=end
