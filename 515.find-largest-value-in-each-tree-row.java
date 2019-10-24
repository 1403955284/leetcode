import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        if(root.left==null&&root.right==null){
            List<Integer> ans = new LinkedList<>();
            ans.add(root.val);
            return ans;
        }
        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);
        boolean flag1 = false;
        boolean flag2 = false;
        while(!queue1.isEmpty()||!queue2.isEmpty()){
            int tmp = Integer.MIN_VALUE;
            while(!queue1.isEmpty()){
                flag1 = true;
                TreeNode cur = queue1.poll();
                tmp = Math.max(tmp, cur.val);
                if(cur.left!=null){
                    queue2.add(cur.left);
                }
                if(cur.right!=null){
                    queue2.add(cur.right);
                }
            }
            if(flag1){
                ans.add(tmp);
            }
            tmp = Integer.MIN_VALUE;
            while(!queue2.isEmpty()){
                flag2 = true;
                TreeNode cur = queue2.poll();
                tmp = Math.max(tmp, cur.val);
                if(cur.left!=null){
                    queue1.add(cur.left);
                }
                if(cur.right!=null){
                    queue1.add(cur.right);
                }
            }
            if(flag2){
                ans.add(tmp);
            }
            flag1 = false;
            flag2 = false;
        }
        return ans;
    }
}
// @lc code=end

