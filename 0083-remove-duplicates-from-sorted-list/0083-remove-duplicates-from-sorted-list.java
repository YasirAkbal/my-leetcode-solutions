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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode itr = head;
        
        while(itr != null) {
            int val = itr.val;
            while(itr.next != null && itr.next.val == val) {
                itr = itr.next;
            }
            
            if(prev.next != itr) {
                prev.next = itr;
            }
            
            prev = itr;
            itr = itr.next;
        }
        
        return dummy.next;
    }
}