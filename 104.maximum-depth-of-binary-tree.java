/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int ans = 0;

    public int maxDepth(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) {
            ans = Math.max(ans, depth);
            return;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
// @lc code=end
