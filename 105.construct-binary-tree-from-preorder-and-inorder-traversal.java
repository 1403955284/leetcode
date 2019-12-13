/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i]==preorder[preStart]){
                index = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, preStart+1, preStart+index-inStart, inStart, index-1);
        root.right = helper(preorder, inorder, preStart+index-inStart+1, preEnd, index+1, inEnd);
        return root;
    }
}
// @lc code=end

