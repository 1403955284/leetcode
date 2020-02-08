/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode tag = root;
        ListNode pre = root;
        int count = 0;
        while (tag.next != null) {
            if (count != n) {
                count++;
                tag = tag.next;
            } else {
                tag = tag.next;
                pre = pre.next;
            }
        }
        pre.next = pre.next.next;
        return root.next;
    }
}
// @lc code=end
