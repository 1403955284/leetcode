import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int X = intervals[0][0];
        int Y = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int curX = intervals[i][0];
            int curY = intervals[i][1];
            // 注意这种情况:[[1,4],[2,3]]
            // 虽然curX<=Y,但是curY<Y
            if (curX <= Y && curY >= Y) {
                Y = intervals[i][1];
            } else if (curX > Y) {
                ans.add(new int[] { X, Y });
                X = intervals[i][0];
                Y = intervals[i][1];
            }
        }
        ans.add(new int[] { X, Y });
        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end
