import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.add(list);
        }

        // 每次把最小堆的头部拿出来接在list后面，然后把它的next放入最小堆
        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            cur.next = next;
            cur = cur.next;
            if (next.next != null) {
                queue.add(next.next);
            }
        }
        return head.next;
    }
}
// @lc code=end
