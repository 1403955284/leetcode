import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
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
    public int findBottomLeftValue(TreeNode root) {


        // // 双队列层次遍历，蠢
        // Queue<TreeNode> queue1 = new LinkedList<>();
        // Queue<TreeNode> queue2 = new LinkedList<>();
        // queue1.add(root);
        // int ans = 0;
        // boolean flag1 = true;
        // boolean flag2 = true;
        // while(!queue1.isEmpty()||!queue2.isEmpty()){
        //     while(!queue1.isEmpty()){
        //         TreeNode cur = queue1.poll();
        //         if(flag1){
        //             ans = cur.val;
        //             flag1 = false;
        //         }
        //         if(cur.left!=null){
        //             queue2.add(cur.left);
        //         }
        //         if(cur.right!=null){
        //             queue2.add(cur.right);
        //         }
        //     }
        //     flag1 = true;
        //     while(!queue2.isEmpty()){
        //         TreeNode cur = queue2.poll();
        //         if(flag2){
        //             ans = cur.val;
        //             flag2 = false;
        //         }
        //         if(cur.left!=null){
        //             queue1.add(cur.left);
        //         }
        //         if(cur.right!=null){
        //             queue1.add(cur.right);
        //         }
        //     }
        //     flag2 = true;
        // }
        // return ans;

        // 单队列，从右往左遍历就行
        Queue<TreeNode> queue1 = new LinkedList<>();
        int ans = 0;
        queue1.add(root);
        while(!queue1.isEmpty()){
            TreeNode cur = queue1.poll();
            ans = cur.val;
            if(cur.right!=null){
                queue1.add(cur.right);
            }
            if(cur.left!=null){
                queue1.add(cur.left);
            }
        }
        return ans;



    }
}
// @lc code=end

