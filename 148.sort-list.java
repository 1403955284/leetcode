/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // =========================== 归并排序 =================================
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return merge(left, right);

    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode cur = new ListNode(0);
        ListNode tmp = cur;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tmp.next = new ListNode(left.val);
                left = left.next;
            } else {
                tmp.next = new ListNode(right.val);
                right = right.next;
            }
            tmp = tmp.next;
        }
        if (left != null) {
            tmp.next = left;
        }
        if (right != null) {
            tmp.next = right;
        }
        return cur.next;

    }

    public ListNode findMid(ListNode root) {
        ListNode fast = root;
        ListNode slow = root;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end
