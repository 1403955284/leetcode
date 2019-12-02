import java.util.HashSet;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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
    private HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        preOrder(root);

        for(int key:set){
            if(set.contains(k-key)&&k-key!=key){
                return true;
            }
        }
        return false;
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        set.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    } 

    
}
// @lc code=end

