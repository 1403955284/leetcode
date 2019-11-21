import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> mark = new HashMap<>();
        List<TreeNode> ans = new LinkedList<>();
        path(root, mark, ans);
        return ans;
    }

    public String path(TreeNode root, Map<String, Integer> mark, List<TreeNode> ans) {
        if (root != null) {
            String curString = root.val + path(root.left, mark, ans) + path(root.right, mark, ans);

            if (mark.containsKey(curString) && mark.get(curString) == 1) {
                ans.add(root);
            }
            mark.put(curString, mark.getOrDefault(curString, 0) + 1);

            return curString;
        } else {
            return null;
        }
    }
}
// @lc code=end
