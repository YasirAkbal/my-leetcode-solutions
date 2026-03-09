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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) { return head; }
        
        ListNode oddTail = new ListNode(0);
        ListNode evenTail = new ListNode(0);
        ListNode evenHead = evenTail;

        ListNode itr = head;
        int i = 1;
        while(itr != null) {
            ListNode next = itr.next;
            if(i % 2 == 1) {
                oddTail.next = itr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = itr;
                evenTail = evenTail.next;
            }
            
            itr.next = null;
            itr = next;
            i++;
        }
        
        oddTail.next = evenHead.next;
        evenTail.next = null;
        
        return head;
    }
}