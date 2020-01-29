/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(0);
        ListNode postHead = new ListNode(0);

        ListNode index = head;

        ListNode preIndex = preHead;
        ListNode postIndex = postHead;

        while (index != null) {
            if (index.val < x) {
                preIndex.next = new ListNode(index.val);
                preIndex = preIndex.next;
            } else {
                postIndex.next = new ListNode(index.val);
                postIndex = postIndex.next;
            }

            index = index.next;
        }
        preIndex.next = postHead.next;
        postIndex.next = null;
        return preHead.next;

    }
}
// @lc code=end
