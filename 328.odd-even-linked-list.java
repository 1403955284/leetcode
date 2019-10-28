/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode curOdd = head;
        ListNode curEven = head.next;
        while(curOdd!=null&&curEven!=null&&curOdd.next!=null&&curEven.next!=null){
            curOdd.next = curOdd.next.next;
            curEven.next = curEven.next.next;
            curOdd = curOdd.next;
            curEven = curEven.next;
        }
        curOdd.next = evenHead;
        return oddHead;
    }
}
// @lc code=end

