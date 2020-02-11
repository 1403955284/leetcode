import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> tmp1 = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode cur = queue1.poll();
                tmp1.add(cur.val);
                if (cur.left != null) {
                    queue2.add(cur.left);
                }
                if (cur.right != null) {
                    queue2.add(cur.right);
                }
            }
            if (tmp1.size() != 0) {
                ans.add(tmp1);
            }
            List<Integer> tmp2 = new ArrayList<>();
            while (!queue2.isEmpty()) {
                TreeNode cur = queue2.poll();
                tmp2.add(cur.val);
                if (cur.left != null) {
                    queue1.add(cur.left);
                }
                if (cur.right != null) {
                    queue1.add(cur.right);
                }
            }
            if (tmp2.size() != 0) {
                ans.add(tmp2);
            }
        }
        return ans;
    }
}
// @lc code=end
