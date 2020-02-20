/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            setDepth(root);
            return max;
        }
        return 0;
    }

    public int setDepth(TreeNode root) {
        if (root != null) {
            int right = setDepth(root.right);
            int left = setDepth(root.left);
            if (right + left > max)
                max = right + left;
            return Math.max(right, left) + 1;
        }
        return 0;
    }
}
// @lc code=end
