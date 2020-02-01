import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> dist;

    public int networkDelayTime(int[][] times, int N, int K) {
        // // ===================== 超时 ================================
        // int ans = Integer.MIN_VALUE;
        // Queue<Integer> queue = new LinkedList<>();
        // // 记录当前到达某节点所需时间
        // int[] curTime = new int[N + 1];
        // int[][] grip = new int[N + 1][N + 1];
        // for (int i = 1; i < N + 1; i++) {
        // for (int j = 1; j < N + 1; j++) {
        // if (i == j) {
        // grip[i][j] = 0;
        // } else {
        // grip[i][j] = Integer.MAX_VALUE;
        // }
        // }
        // curTime[i] = Integer.MAX_VALUE;
        // }
        // for (int i = 0; i < times.length; i++) {
        // int src = times[i][0];
        // int target = times[i][1];
        // int time = times[i][2];
        // grip[src][target] = time;
        // }
        // queue.add(K);
        // curTime[K] = 0;
        // while (!queue.isEmpty()) {
        // int src = queue.poll();
        // for (int i = 1; i <= N; i++) {
        // if (i != src && grip[src][i] != Integer.MAX_VALUE
        // && (curTime[i] == Integer.MAX_VALUE || curTime[src] + grip[src][i] <=
        // curTime[i])) {
        // curTime[i] = curTime[src] + grip[src][i];
        // queue.add(i);
        // }
        // }
        // }

        // for (int i = 1; i <= N; i++) {
        // ans = Math.max(ans, curTime[i]);
        // if (ans == Integer.MAX_VALUE) {
        // return -1;
        // }
        // }
        // return ans;
        // // ======================================================================

        // // =================================== 迪杰斯特拉算法(答案)
        // ===========================
        // Map<Integer, List<int[]>> graph = new HashMap();
        // for (int[] edge : times) {
        // if (!graph.containsKey(edge[0]))
        // graph.put(edge[0], new ArrayList<int[]>());
        // graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        // }
        // dist = new HashMap();
        // for (int node = 1; node <= N; ++node)
        // dist.put(node, Integer.MAX_VALUE);

        // dist.put(K, 0);
        // boolean[] seen = new boolean[N + 1];

        // while (true) {
        // int candNode = -1;
        // int candDist = Integer.MAX_VALUE;
        // for (int i = 1; i <= N; ++i) {
        // if (!seen[i] && dist.get(i) < candDist) {
        // candDist = dist.get(i);
        // candNode = i;
        // }
        // }

        // if (candNode < 0)
        // break;
        // seen[candNode] = true;
        // if (graph.containsKey(candNode))
        // for (int[] info : graph.get(candNode))
        // dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        // }

        // int ans = 0;
        // for (int cand : dist.values()) {
        // if (cand == Integer.MAX_VALUE)
        // return -1;
        // ans = Math.max(ans, cand);
        // }
        // return ans;
        // // ==================================================================

        // ==================================== 迪姐斯特拉算法(自己重写)
        // =================================================================================

        // 存储节点间时延
        int[][] graph = new int[N + 1][N + 1];
        // 存储该节点是否已找到最短路
        boolean[] visited = new boolean[N + 1];

        // 存储从源点到该点的最小时延
        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = -1;
            }
        }

        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }
        Arrays.fill(dist, -1);

        for (int i = 1; i <= N; i++) {
            dist[i] = graph[K][i];
        }
        dist[K] = 0;
        // 找到除了K以外的N-1个节点的，到K的最小距离
        int count = N - 1;
        while (count > 0) {
            int minDist = Integer.MAX_VALUE;
            int minIndex = 1;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && dist[i] != -1 && dist[i] < minDist) {
                    minDist = dist[i];
                    minIndex = i;
                }
            }
            visited[minIndex] = true;
            // 更新K到所有点的距离
            for (int i = 1; i <= N; i++) {
                if (graph[minIndex][i] != -1) {
                    if (dist[i] != -1) {
                        dist[i] = Math.min(dist[i], dist[minIndex] + graph[minIndex][i]);
                    } else {
                        dist[i] = dist[minIndex] + graph[minIndex][i];
                    }
                }
            }
            count--;
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
        // ==========================================================================================
    }
}
// @lc code=end
