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
    ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;
        
        ListNode newNode;
        ListNode tail;
        if(head1.val < head2.val) {
            newNode = head1;
            head1 = head1.next;
        } else {
            newNode = head2;
            head2 = head2.next;
        }
        tail = newNode;
        
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        if(head1 != null)
            tail.next = head1;
        else if(head2 != null)
            tail.next = head2;
        
        return newNode;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode next = slow.next;
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        
        return merge(left, right);
    }
}