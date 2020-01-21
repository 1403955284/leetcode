import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // // ================================= 非递归，采用一栈一list或者双栈的形式 ====================================
        // List<Integer> ans = new ArrayList<>();
        // if (root == null) {
        // return ans;
        // }
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // while (!stack.isEmpty()) {
        // TreeNode cur = stack.pop();
        // ans.add(cur.val);
        // if (cur.left != null) {
        // stack.push(cur.left);
        // }
        // if (cur.right != null) {
        // stack.push(cur.right);
        // }
        // }
        // Collections.reverse(ans);
        // return ans;
        // //
        // =============================================================================================================

        // ==================== 采用一栈、辅助变量h和c的形式 ( beats 100%)==========================

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 记录当前已经输出过的节点
        TreeNode h = root;
        TreeNode c = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                stack.push(c.left);
            } else if (c.right != null && h != c.right) {
                stack.push(c.right);
            } else {
                stack.pop();
                ans.add(c.val);
                h = c;
            }
        }
        return ans;
    }
}
// @lc code=end
