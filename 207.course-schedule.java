import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 表示每门课的入度，即先行课的数量
        int[] digit = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int[] cur : prerequisites) {
            digit[cur[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (digit[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            // 当前可以完成的先行课
            int pre = queue.poll();
            numCourses--;
            for (int[] cur : prerequisites) {
                if (cur[1] != pre) {
                    continue;
                }
                if (--digit[cur[0]] == 0) {
                    queue.add(cur[0]);
                }
            }
        }
        return numCourses == 0;
    }
}
// @lc code=end
