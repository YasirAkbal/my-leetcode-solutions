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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) { return null; }
        ListNode[] nodes = new ListNode[30];
        
        ListNode itr = head;
        int i = 0;
        while(head != null) {
            nodes[i] = head;
            head = head.next;
            i++;
        }
    
        ListNode nodeToDelete = nodes[i-n];
        
        if(i-n-1 > 0) {
            ListNode nodePrev = nodes[i-n-1];
            nodePrev.next = nodeToDelete.next;
            return nodes[0];
        } else if(i-n-1 == -1) {
           return nodes[0].next; 
        } else {
           nodes[0].next = null;
           return nodes[0]; 
        }
    }
}