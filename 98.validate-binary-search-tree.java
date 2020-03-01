import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // ===================递归============================
        // return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // ================ 非递归 ===================

        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        boolean flag = true;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (flag) {
                    flag = false;
                } else {
                    if (prev >= root.val) {
                        return false;
                    }
                }
                prev = root.val;
                root = root.right;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
// @lc code=end
