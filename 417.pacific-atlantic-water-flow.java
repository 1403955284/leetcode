import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean[][] visited1 = new boolean[matrix.length][matrix[0].length];
                boolean[][] visited2 = new boolean[matrix.length][matrix[0].length];
                if (bfs1(i, j, matrix,matrix[i][j],visited1) && bfs2(i, j, matrix,matrix[i][j],visited2)) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    public boolean bfs1(int i, int j, int[][] matrix,int tmp,boolean[][] visited) {
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length||tmp<matrix[i][j]||visited[i][j]){
            return false;
        }
        if (i == 0 || j == 0) {
            return true;
        }
        visited[i][j] = true;
        return bfs1(i-1, j, matrix, matrix[i][j],visited) ||
               bfs1(i+1, j, matrix, matrix[i][j],visited) ||
               bfs1(i, j-1, matrix, matrix[i][j],visited) ||
               bfs1(i, j+1, matrix, matrix[i][j],visited);
        
    }

    public boolean bfs2(int i, int j, int[][] matrix,int tmp,boolean[][] visited) {
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length||tmp<matrix[i][j]||visited[i][j]){
            return false;
        }
        if (i == matrix.length - 1 || j == matrix[0].length - 1) {
            return true;
        }
        visited[i][j] = true;
        return bfs2(i-1, j, matrix, matrix[i][j],visited) ||
               bfs2(i+1, j, matrix, matrix[i][j],visited) ||
               bfs2(i, j-1, matrix, matrix[i][j],visited) ||
               bfs2(i, j+1, matrix, matrix[i][j],visited);
    }
}
// @lc code=end
