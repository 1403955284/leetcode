import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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
    private List<Integer> nums = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        }
        inOrder(root);
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<nums.size()-1;i++){
            ans = Math.min(ans, nums.get(i+1)-nums.get(i));
        }
        return ans;
    }

    public void inOrder(TreeNode root){
        if(root.left!=null){
            inOrder(root.left);
        }
        nums.add(root.val);
        if(root.right!=null){
            inOrder(root.right);
        }
    }
}
// @lc code=end

