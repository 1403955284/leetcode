import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start

// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val,List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        List<List<Integer>> ans = new LinkedList<>();
        if(root==null){
            return ans;
        }
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            while (!queue1.isEmpty()) {
                Node cur = queue1.remove();
                tmp.add(cur.val);
                queue2.addAll(cur.children);
            }
            if (!tmp.isEmpty()) {
                ans.add(tmp);
            }
            List<Integer> tmp2 = new LinkedList<>();
            while (!queue2.isEmpty()) {
                Node cur = queue2.remove();
                tmp2.add(cur.val);
                queue1.addAll(cur.children);
            }
            if (!tmp2.isEmpty()) {
                ans.add(tmp2);
            }
        }
        return ans;
    }
}
// @lc code=end
