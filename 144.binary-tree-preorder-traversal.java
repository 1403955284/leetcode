import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        // ====================================== 非递归 ===============================
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur= stack.pop();
            ans.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return ans;
    }
}
// @lc code=end

