import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        // key为原节点，value为生成的新节点
        Map<Node, Node> map = new HashMap<>();
        // 遍历链表，生成新节点
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            map.put(cur, new Node(cur.val));
            cur = next;
        }
        cur = head;
        // 连接新节点
        while (cur != null) {
            next = cur.next;
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = next;
        }
        return map.get(head);

    }
}
// @lc code=end
