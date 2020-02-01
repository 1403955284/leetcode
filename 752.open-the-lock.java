import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    private int ans = -1;

    public int openLock(String[] deadends, String target) {
        // // ==================================== 答案 ================================
        int ans = 0;
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        for (String cur : deadends) {
            dead.add(cur);
        }

        queue.add("0000");
        queue.add(null);
        visited.add("0000");
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur == null) {
                ans++;
                if (queue.peek() != null) {
                    queue.add(null);
                }
            } else if (cur.equals(target)) {
                return ans;
            } else if (!dead.contains(cur)) {
                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((cur.charAt(i) - '0') + d + 10) % 10;
                        String nei = cur.substring(0, i) + ("" + y) + cur.substring(i + 1);
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.add(nei);
                        }
                    }
                }
            }
        }
        return -1;
        //
        // ============================================================================

        // // ==================================== bfs
        // // =====================================
        // List<String> dead = new ArrayList<>();
        // List<String> visited = new ArrayList<>();

        // for (String cur : deadends) {
        // dead.add(cur);
        // }
        // bfs(dead, visited, target, "0000", 0);
        // return ans;
        // //
        // ==============================================================================
    }

    public void bfs(List<String> dead, List<String> visited, String target, String cur, int depth) {
        if (cur.equals(target)) {
            ans = depth;
            return;
        }
        if (dead.contains(cur)) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            for (int d = -1; d <= 1; d += 2) {
                int y = ((cur.charAt(i) - '0') + d + 10) % 10;
                String nei = cur.substring(0, i) + ("" + y) + cur.substring(i + 1);
                if (!visited.contains(nei)) {
                    List<String> curVisited = new ArrayList<>(visited);
                    curVisited.add(nei);
                    bfs(dead, curVisited, target, nei, depth + 1);
                }
            }
        }
    }
}
// @lc code=end
