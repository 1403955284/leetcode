/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int rob(TreeNode root) {
        // return helper(root, true);

        // ============= 答案 =============
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    // res[0]为不包括根节点的最大值，res[1]为包括根节点的最大值
    private int[] doRob(TreeNode root) {
        int[] res = new int[2];
        if (root == null)
            return res;
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        // 不包含根节点，最大值为两个子树的最大值之和
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

    // ================= 递归很费时间 ================
    private int helper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag) {
            return Math.max(root.val + helper(root.left, false) + helper(root.right, false),
                    helper(root.left, flag) + helper(root.right, flag));
        } else {
            return helper(root.left, true) + helper(root.right, true);
        }
    }
}
// @lc code=end
