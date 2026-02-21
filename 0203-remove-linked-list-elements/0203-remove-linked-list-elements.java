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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode itr = head;
        
        while(itr != null) {
            if(itr.val == val) {
                if(prev == null) {
                    head = itr.next;
                } else if(itr.next == null) {
                    prev.next = null;
                } else {
                    prev.next = itr.next;
                }
            } else {
                prev = itr;
            }
            
            itr = itr.next;
        }
        
        return head;
    }
}