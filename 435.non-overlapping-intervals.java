import java.util.Arrays;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照结束点从小到大排序
        // 这样遍历的时候可以尽可能多的添加区间，即剔除最少的区间使得区间不覆盖
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // for (int i = 0; i < intervals.length; i++) {
        //     System.out.println("[" + intervals[i][0] + "," + intervals[i][1] + "]");
        // }
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
// @lc code=end
