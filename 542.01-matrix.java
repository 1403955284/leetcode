import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // // ===================== 动态规划做法 =========================
        // int[][] ans = new int[matrix.length][matrix[0].length];
        // for(int i = 0;i<ans.length;i++){
        // for(int j = 0;j<ans[0].length;j++){
        // // 避免后面+1导致溢出，特意将 MAX_VALUE缩小一点
        // ans[i][j] = Integer.MAX_VALUE-10000;
        // }
        // }
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // if (matrix[i][j] == 0) {
        // ans[i][j] = 0;
        // } else {
        // if(i>0){
        // ans[i][j] = Math.min(ans[i][j],ans[i-1][j]+1);
        // }
        // if(j>0){
        // ans[i][j] = Math.min(ans[i][j],ans[i][j-1]+1);
        // }
        // }
        // }
        // }

        // for (int i = matrix.length-1; i >= 0; i--) {
        // for (int j = matrix[0].length-1; j >= 0; j--) {

        // if(i<matrix.length-1){
        // ans[i][j] = Math.min(ans[i][j],ans[i+1][j]+1);
        // }
        // if(j<matrix[0].length-1){
        // ans[i][j] = Math.min(ans[i][j],ans[i][j+1]+1);
        // }

        // }
        // }
        // return ans;
        // // ===================== 动态规划做法 =========================

        // ======================== bfs做法 =============================

        int[][] ans = new int[matrix.length][matrix[0].length];
        int[][] direct = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    queue.add(tmp);
                } else {
                    // 避免后面+1导致溢出，特意将 MAX_VALUE缩小一点
                    ans[i][j] = Integer.MAX_VALUE - 10000;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newI = tmp[0] + direct[i][0];
                int newJ = tmp[1] + direct[i][1];
                if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length) {
                    if (ans[newI][newJ] > ans[tmp[0]][tmp[1]] + 1) {
                        ans[newI][newJ] = ans[tmp[0]][tmp[1]] + 1;
                        queue.add(new int[] { newI, newJ });
                    }
                }
            }
        }
        return ans;
        // ======================== bfs做法 =============================

    }
}
// @lc code=end
