/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        slow.next=null;
        while(head!=null){
            if(newHead==null){
                return true;
            }
            if(head.val!=newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    /**
     * 反转链表，重要
     * @param root
     * @return
     */
    public ListNode reverse(ListNode root){
        if(root == null || root.next == null) return root;
        
        ListNode newHead = reverse(root.next);
        root.next.next = root;
        root.next = null;
        
        return newHead;
    }
}
// @lc code=end

