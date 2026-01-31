/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode itr = head;
        ListNode next;
        
        while(itr != null) {
            next = itr.next;
            itr.next = prev;
            prev = itr;
            itr = next;
        }
        
        return prev;
    }
}