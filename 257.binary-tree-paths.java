import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    private List<String> ans = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return ans;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(root.val));
        if(root.left==null&&root.right==null){
            ans.add(stringBuilder.toString());
        }
        if(root.left!=null){
            helper(root.left, stringBuilder, ans);
        }
        if(root.right!=null){
            helper(root.right, stringBuilder, ans);
        }
        return ans;
    }

    public void helper(TreeNode root,StringBuilder str,List<String> ans){
        StringBuilder tmp = new StringBuilder(str);
        tmp.append("->"+String.valueOf(root.val));
        if(root.left==null&&root.right==null){
            ans.add(tmp.toString());
            return ;
        }
        if(root.left!=null){
            helper(root.left, tmp, ans);
        }
        if(root.right!=null){
            helper(root.right, tmp, ans);
        }
    }
}
// @lc code=end

