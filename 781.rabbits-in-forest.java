/*
 * @lc app=leetcode id=781 lang=java
 *
 * [781] Rabbits in Forest
 */

// @lc code=start
class Solution {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        // 记录 说和它同一颜色的兔子的数量 这个值一样的个数
        /**
         * 如测试用例 [1,1,2] count[1] = 2; count[2] = 1; 每当count[i] = sum 中 sum =
         * i+1时，一种颜色就统计完成了 此时清空count[i]
         * 
         * count[1] = 2 表示有两只兔子说和它同一颜色的兔子有1只，此时 sum = i + 1 该颜色的容纳已经上限
         * 
         * 当sum < i+1时，该颜色还有统计余地，可以继续累加以保证总兔子数量最少
         */
        int[] count = new int[1000];
        int ans = 0;
        for (int i = 0; i < answers.length; i++) {
            int curSign = answers[i];
            count[curSign]++;
            if (count[curSign] == curSign + 1) {
                ans += count[curSign];
                count[curSign] = 0;
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (count[i] != 0) {
                ans += i + 1;
            }
        }
        return ans;
    }
}
// @lc code=end
