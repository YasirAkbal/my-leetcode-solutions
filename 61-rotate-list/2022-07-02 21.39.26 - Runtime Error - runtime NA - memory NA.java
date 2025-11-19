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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode rightKth = head;
        ListNode tail = head;
        
        for(int i=0;i<k;i++) {
            tail = tail.next;
        }
        
        while(tail.next != null) {
            tail = tail.next;
            rightKth = rightKth.next;
        }
        
        ListNode newHead = rightKth.next;
        rightKth.next = null;
        tail.next = head;
        
        return newHead;
    }
}