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
    public ListNode reverseList(ListNode head) {
        ListNode itrNode = head;
        ListNode prevNode = null;
        ListNode nextNode = itrNode.next;
        
        while(itrNode != null && itrNode.next != null) {
            ListNode temp = nextNode.next;
            itrNode.next = prevNode;
            nextNode.next = itrNode;
            
            prevNode = nextNode;
            itrNode = temp;
            if(itrNode != null)
                nextNode = itrNode.next;
        }
        
        if(itrNode != null && itrNode.next == null) {
            itrNode.next = prevNode;
        }
        
        return itrNode == null ? prevNode : itrNode;
    }
}