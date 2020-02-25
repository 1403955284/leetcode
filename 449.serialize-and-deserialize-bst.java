import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                nodes.add("#");
            } else {
                nodes.add(String.valueOf(cur.val));
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return String.join(",", nodes);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        Queue<TreeNode> queue = new LinkedList<>();
        String rootVal = nodes.poll();
        if (rootVal.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootVal));
        queue.add(root);
        while (!nodes.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                String left = nodes.poll();
                String right = nodes.poll();
                cur.left = left.equals("#") ? null : new TreeNode(Integer.valueOf(left));
                cur.right = right.equals("#") ? null : new TreeNode(Integer.valueOf(right));
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
