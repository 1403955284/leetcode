/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 如果当前grid[i][j]为1，就把与之相连的陆地全部标记为0避免重复计算岛屿数量
                    helper(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void helper(char[][] grid, int i, int j) {
        if (i < grid.length && i >= 0 && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            helper(grid, i - 1, j);
            helper(grid, i + 1, j);
            helper(grid, i, j - 1);
            helper(grid, i, j + 1);
        }
    }
}
// @lc code=end
