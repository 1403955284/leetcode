import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {


        // =============== dfs做法 ================
        // int count = 0;
        // int[] visited = new int[M.length];
        // for(int i = 0;i<M.length;i++){
        // if(visited[i]==0){
        // dfs(M, visited, i);
        // count++;
        // }
        // }
        // return count;
        // =============== dfs做法 ================






        // // ================ bfs做法 ===============

        // int count = 0;
        // int[] visited = new int[M.length];
        // Queue<Integer> queue = new LinkedList<>();
        // for (int i = 0; i < M.length; i++) {
        //     if (visited[i] == 0) {
        //         queue.add(i);
        //         while (!queue.isEmpty()) {
        //             int cur = queue.poll();
        //             visited[cur] = 1;
        //             for (int j = 0; j < M.length; j++) {
        //                 if (M[cur][j] == 1 && visited[j] == 0) {
        //                     queue.add(j);
        //                 }
        //             }
        //         }
        //         count++;
        //     }
        // }
        // return count;
        // // ================ bfs做法 ===============


        // =========================== 并查集做法 =======================
        int count = 0;
        int[] parent = new int[M.length];
        for(int i = 0;i<parent.length;i++){
            parent[i] = -1;
        }
        for(int i = 0;i<M.length;i++){
            for(int j = 0;j<M.length;j++){
                if(M[i][j]==1&&i!=j){
                    union(parent, i, j);
                }
            }
        }
        for(int i = 0;i<parent.length;i++){
            if(parent[i]==-1){
                count++;
            }
            System.out.println(parent[i]);
        }
        return count;
        // =========================== 并查集做法 =======================

    }

    public int find(int[] parent,int i){
        if(parent[i] == -1){
            return i;
        }
        return find(parent, parent[i]);
    }

    // 合并点i和点j
    public void union(int[] parent,int i,int j){
        int iParent = find(parent, i);
        int jParent = find(parent, j);
        // 如果i和j不是同一个父亲，则将他们父亲归并,使之指向同一个父亲
        if(iParent!=jParent){
            parent[iParent] = jParent;
        }
    }

    public void dfs(int[][] M, int[] visited, int raw) {
        for (int i = 0; i < M.length; i++) {
            if (M[raw][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfs(M, visited, i);
            }
        }
    }

}
// @lc code=end
