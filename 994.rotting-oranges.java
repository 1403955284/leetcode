import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (2 == grid[i][j])
                    queue.offer(i * grid[0].length + j);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                int y = tmp / grid[0].length, x = tmp % grid[0].length;
                for (int[] dir : directions) {
                    int ny = y + dir[0], nx = x + dir[1];
                    if (0 <= ny && ny < grid.length && 0 <= nx && nx < grid[0].length) {
                        if (1 == grid[ny][nx]) {
                            grid[ny][nx] = 2;
                            queue.offer(ny * grid[0].length + nx);
                        }
                    }
                }
            }
            time++;
        }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (1 == grid[i][j])
                    return -1;

        return time > 0 ? time - 1 : time;
    }
}
// @lc code=end
