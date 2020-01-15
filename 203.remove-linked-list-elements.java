/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        head = ans;
        while(head.next!=null){
            if(head.next.val==val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return ans.next;
    }
}
// @lc code=end
