import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        int maxTime = 0;
        List<Integer> ans = new ArrayList<>();
        for (int cur : map.keySet()) {
            maxTime = Math.max(maxTime, map.get(cur));
        }
        for (int cur : map.keySet()) {
            if (map.get(cur) == maxTime) {
                ans.add(cur);
            }
        }
        int[] cur = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            cur[i] = ans.get(i);
        }
        return cur;
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }

    public void helper(TreeNode root) {
        if (root != null) {
            int cur = getSum(root);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
            helper(root.left);
            helper(root.right);
        }
    }
}
// @lc code=end
