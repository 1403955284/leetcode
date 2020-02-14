/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode root = head;
        ListNode next = head.next;
        while (next != null) {
            root.next = prev;
            prev = root;
            root = next;
            next = next.next;
        }
        root.next = prev;
        return root;
    }
}
// @lc code=end
