/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 把其中一条链首尾相接，问题转化为找到环状链表的入环点，同问题leetcode142
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tmp = headA;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = headA;
        ListNode fast = headB;
        ListNode slow = headB;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = headB;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                tmp.next = null;
                return slow2;
            }
        }
        tmp.next = null;
        return null;

    }
}
// @lc code=end
