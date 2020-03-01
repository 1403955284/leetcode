import java.util.Arrays;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = add(root, preorder[i]);
        }
        return root;
    }

    public TreeNode add(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (root.val > num) {
            root.left = add(root.left, num);
        } else {
            root.right = add(root.right, num);
        }
        return root;
    }
}
// @lc code=end
