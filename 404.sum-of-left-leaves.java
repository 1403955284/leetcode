/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return ans;
    }

    public void helper(TreeNode root,boolean flag){
        if(root==null){
            return;
        }
        if(flag&&root.left==null&&root.right==null){
            ans+=root.val;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
    }
}
// @lc code=end

