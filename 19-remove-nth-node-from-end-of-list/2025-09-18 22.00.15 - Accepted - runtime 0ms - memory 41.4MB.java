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
        
        if(n == 1) { //last node
            ListNode prevNode = nodes[i-n-1];
            prevNode.next = null;
            return nodes[0];
        } else if(i-n == 0) { //first node
            return nodes[1];
        } else { //between
            ListNode prevNode = nodes[i-n-1];
            prevNode.next = nodeToDelete.next;
            return nodes[0];
        }
    }
}