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
        ListNode[] nodes = new ListNode[30];
        
        ListNode itr = head;
        int i = 0;
        while(head != null) {
            nodes[i] = head;
            head = head.next;
            i++;
        }
    
        ListNode nodeToDelete = nodes[i-n];
        ListNode nodePrev = nodes[i-n-1];
        
        nodePrev.next = nodeToDelete.next;
        
        return nodes[0];
    }
}