/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    public void helper(TreeNode root, int curSum) {
        if (root == null) {
            return;
        }
        if (root.val - curSum == 0) {
            ans++;
        }
        helper(root.left, curSum - root.val);
        helper(root.right, curSum - root.val);
    }
}
// @lc code=end
