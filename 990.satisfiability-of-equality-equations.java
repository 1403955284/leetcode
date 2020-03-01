import java.util.Arrays;

/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        Arrays.fill(parent, -1);
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(parent, s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (find(parent, s.charAt(0) - 'a') == find(parent, s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }
}
// @lc code=end
