/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    private int[] parent = new int[1001];
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        for(int i = 0;i<edges.length;i++){
            parent[i] = i;
        }
        for(int i = 0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            // 如果是这条边的两个点是同一个父亲，说明这条边是冗余边，更新res
            if(findParent(x)==findParent(y)){
                res[0] = x;
                res[1] = y;
            }
            union(x, y);
        }
        return res;
    }

    public void union(int x,int y){
        int xParent = findParent(x);
        int yParent = findParent(y);
        if(xParent!=yParent){
            parent[yParent] = xParent;
        }
    }

    public int findParent(int x){
        if(parent[x]!=x){
            return findParent(parent[x]);
        }
        return x;
    }
}
// @lc code=end

