import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // =========================== 非递归方式 =============================
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||root!=null){

            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
// @lc code=end

