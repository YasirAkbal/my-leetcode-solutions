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
        if(head == null || head.next == null) return head;
        
        ListNode rightKth = head;
        ListNode tail = head;
        
        int i;
        for(i=1;i<=k && tail.next != null;i++) {
            tail = tail.next;
        }
        
        if(i == k) {
            return head;
        } else if(i < k) {
            int mod = k%i;
            tail = head;
            for(i=1;i<=mod && tail.next != null;i++) 
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