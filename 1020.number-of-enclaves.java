/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] A) {
        int ans = 0;
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<A[0].length;j++){
                if(A[i][j]==1){
                    boolean[][] visited = new boolean[A.length][A[0].length];
                    if(!dfs(i, j, A, visited)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public boolean dfs(int i,int j,int[][] A,boolean[][] visited){
        if(i<0||j<0||i>=A.length||j>=A[0].length||A[i][j]==0||visited[i][j]){
            return false;
        }
        if(i==0||j==0||i==A.length-1||j==A[0].length-1){
            return true;
        }
        visited[i][j] = true;
        return dfs(i-1, j, A, visited) ||
               dfs(i+1, j, A, visited) ||
               dfs(i, j-1, A, visited) ||
               dfs(i, j+1, A, visited);
    }
}
// @lc code=end

