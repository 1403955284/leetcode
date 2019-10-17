/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        while(root.val<p.val&&root.val<q.val||root.val>p.val&&root.val>q.val){
            if(root.val<p.val&&root.val<q.val){
                root = root.right;
            }
            if(root.val>p.val&&root.val>q.val){
                root = root.left;
            }

            if(root.val==p.val){
                root = p;
                break;
            }
            if(root.val==q.val){
                root = q;
                break;
            }
        }
        return root;
    }
}
// @lc code=end

