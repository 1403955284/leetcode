import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> height = new TreeMap<>();
        for (int[] cur : buildings) {
            for (int i = cur[0]; i <= cur[1]; i++) {
                if (height.containsKey(i)) {
                    height.put(i, Math.max(height.get(i), cur[2]));
                } else {
                    height.put(i, cur[2]);
                }
            }
        }
        int prev = -1;
        int lastKey = 0;
        for (int key : height.keySet()) {
            lastKey = key;
            if (prev == -1) {
                prev = height.get(key);
                List<Integer> tmp = new ArrayList<>();
                tmp.add(key);
                tmp.add(height.get(key));
                ans.add(tmp);
            } else if (!height.containsKey(key + 1) || prev != height.get(key + 1)) {
                prev = !height.containsKey(key + 1) ? 0 : height.get(key + 1);
                List<Integer> tmp = new ArrayList<>();
                tmp.add(key);
                tmp.add(prev);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
// @lc code=end
