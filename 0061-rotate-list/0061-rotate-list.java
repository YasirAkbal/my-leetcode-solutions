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
        if(head == null) { return null; }
        ListNode tail = head;
        int size = 1;
        
        while(tail.next != null) {
            tail = tail.next;
            size++;
        }
        
        k = k % size;
        if(k == 0) { return head; }
        
        int leftLen = size - k;
        ListNode curr = head;
        for(int i = 1; i < leftLen; i++) {
            curr = curr.next;
        }
        
        ListNode temp = curr.next;
        curr.next = null;
        tail.next = head;
        
        return temp;
    }
}