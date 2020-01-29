/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null)
            return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        // 此处一直在记录当前的最长同值路径，包含了跨越根节点连接左子树和右子树的情况
        ans = Math.max(ans, arrowLeft + arrowRight);
        // 这里返回的是以当前节点为根的情况下的最长同值路径，所以要么是左子树中的最长同值路径长
        // 加上根节点，要么是有字数中的最长同值路径长加上根节点。而总问题的答案是由ans变量来标示的
        return Math.max(arrowLeft, arrowRight);
    }
}
// @lc code=end
