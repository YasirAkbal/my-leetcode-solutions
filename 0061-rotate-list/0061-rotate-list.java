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
        ListNode right = head;
        int size = 0;
        while(right != null) {
            right = right.next;
            size++;
        }
        
        k = k % size;
        if(k == 0) { return head; }

        int i = 0;
        right = head;
        while(right != null && i < k) {
            right = right.next;
            i++;
        }
        
        ListNode left = head;
        while(right != null && right.next != null) {
            right = right.next;
            left = left.next;
        }
        
        ListNode rightHead = left.next;
        left.next = null;
        right.next = head;
        head = rightHead;
        
        
        return head;
    }
}