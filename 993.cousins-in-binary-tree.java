/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int xpar, xdep, ypar, ydep;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, 1, x, y, root.val);
        dfs(root.right, 1, x, y, root.val);
        return (xpar != ypar) && (xdep == ydep);
    }

    public void dfs(TreeNode node, int dep, int x, int y, int par) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xpar = par;
            xdep = dep;
        } else if (node.val == y) {
            ypar = par;
            ydep = dep;
        } else {
            dfs(node.left, dep + 1, x, y, node.val);
            dfs(node.right, dep + 1, x, y, node.val);
        }
    }
}
// @lc code=end
