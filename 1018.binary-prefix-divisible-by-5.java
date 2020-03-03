/*
 * @lc app=leetcode id=1018 lang=java
 *
 * [1018] Binary Prefix Divisible By 5
 */

// @lc code=start
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        if (A == null || A.length == 0) {
            return ans;
        }
        int cur = 0;
        for (int a : A) {
            cur = ((cur << 1) + a) % 5;
            ans.add(cur == 0 ? true : false);
        }
        return ans;
    }
}
// @lc code=end
