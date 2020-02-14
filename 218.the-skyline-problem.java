import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] b : buildings) {
            points.add(new int[] { b[0], 0 });
            points.add(new int[] { b[1], 0 });
        }

        Collections.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int[] b : buildings) {
            for (int[] p : points) {
                if (p[0] >= b[0] && p[0] < b[1]) {
                    p[1] = Math.max(p[1], b[2]);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = null;
        for (int[] p : points) {
            if (prev == null) {
                List<Integer> list = new ArrayList<>();
                list.add(p[0]);
                list.add(p[1]);
                res.add(list);
                prev = list;
            } else if (prev.get(0) == p[0]) {
                if (prev.get(1) == p[1])
                    continue;
                if (prev.get(1) < p[1]) {
                    res.remove(prev);
                }
                List<Integer> list = new ArrayList<>();
                list.add(p[0]);
                list.add(p[1]);
                res.add(list);
                prev = list;
            } else if (prev.get(1) != p[1]) {
                List<Integer> list = new ArrayList<>();
                list.add(p[0]);
                list.add(p[1]);
                res.add(list);
                prev = list;
            }
        }
        return res;
    }
}
// @lc code=end
