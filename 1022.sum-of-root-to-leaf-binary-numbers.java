import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<String> nums = new LinkedList<>();
        int ans = 0;
        backtrack(nums, new StringBuilder(), root);
        for(String cur:nums){
            ans+=Integer.parseInt(cur,2);
        }
        return ans;
    }

    public void backtrack(List<String> nums,StringBuilder cur,TreeNode root){
        StringBuilder tmp = new StringBuilder(cur);
        tmp.append(root.val);
        if(root.left==null&&root.right==null){
            nums.add(tmp.toString());
        }
        if(root.left!=null){
            backtrack(nums, tmp, root.left);
        }
        if(root.right!=null){
            backtrack(nums, tmp, root.right);
        }
    }
}
// @lc code=end

