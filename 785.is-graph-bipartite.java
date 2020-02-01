import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    int curColor = color[cur];
                    for (int next : graph[cur]) {
                        if (color[next] == curColor) {
                            return false;
                        }
                        if (color[next] == 0) {
                            queue.add(next);
                            if (color[cur] == 1) {
                                color[next] = 2;
                            } else if (color[cur] == 2) {
                                color[next] = 1;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end
