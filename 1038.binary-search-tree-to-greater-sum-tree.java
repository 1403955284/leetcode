/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        return helper(root, 0);
    }

    public TreeNode helper(TreeNode root, int rightSum) {
        if (root == null) {
            return null;
        }
        int right = sum(root.right);
        TreeNode ans = new TreeNode(root.val + right + rightSum);
        ans.right = helper(root.right, rightSum);
        ans.left = helper(root.left, ans.val);
        return ans;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
// @lc code=end
