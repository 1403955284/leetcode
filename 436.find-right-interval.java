import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=436 lang=java
 *
 * [436] Find Right Interval
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer,Integer> start = new TreeMap<>();
        // TreeMap<Integer,Integer> end = new TreeMap<>();

        int[] ans = new int[intervals.length];
        for(int i = 0;i<intervals.length;i++){
            start.put(intervals[i][0],i);
            // end.put(intervals[i][1],i);
        }
        for(int i = 0;i<intervals.length;i++){
            Map.Entry<Integer,Integer> pos = start.ceilingEntry(intervals[i][1]);
            ans[i] = pos == null ? -1 : pos.getValue();
        }
        return ans;
    }
}
// @lc code=end

