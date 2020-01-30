/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int target = image[sr][sc];
        bfs(image, visited, sr, sc, target, newColor);
        return image;
    }

    public void bfs(int[][] image, boolean[][] visited, int sr, int sc, int target, int newColor) {
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && !visited[sr][sc]
                && image[sr][sc] == target) {
            visited[sr][sc] = true;
            image[sr][sc] = newColor;
            bfs(image, visited, sr - 1, sc, target, newColor);
            bfs(image, visited, sr + 1, sc, target, newColor);
            bfs(image, visited, sr, sc - 1, target, newColor);
            bfs(image, visited, sr, sc + 1, target, newColor);
        }
    }
}
// @lc code=end
