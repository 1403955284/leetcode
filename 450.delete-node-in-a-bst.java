/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// 如果要删除的节点比根 root 的值小，则从左子树中删除 key 节点；
// 如果要删除的节点比根 root 的值大，则从右子树中删除 key 节点；
// 当 key 和 root 的值相等的时候，则需要删除该节点，这其中又有三种不同的情况：

// 当该节点 (root 节点) 的左子树为空时，断开该节点与右子树的连接 (注意保存右子树)，返回该节点的右子树
// 当该节点的右子树为空时，断开连接，返回该节点的左子树
// 该节点左右子树都不为空时，将该节点右子树中的最小节点替代该元素
// 这里使用两个辅助方法，minimun 方法用于返回一棵树的最小节点；removeMin 方法用于删除一棵树的最小节点

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null) {
                TreeNode right = root.right;
                root.right = null;
                return right;
            } else if (root.right == null) {
                TreeNode left = root.left;
                root.left = null;
                return left;
            } else {
                TreeNode rMin = minimun(root.right);
                rMin.right = removeMin(root.right);
                rMin.left = root.left;

                root.left = root.right = null;
                return rMin;
            }
        }

    }

    private TreeNode minimun(TreeNode node) {
        if (node.left == null)
            return node;
        return minimun(node.left);
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
// @lc code=end
