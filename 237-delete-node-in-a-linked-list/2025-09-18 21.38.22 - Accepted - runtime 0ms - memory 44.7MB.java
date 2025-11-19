/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        ListNode itrNode = node;
        
        while(itrNode.next != null) {
            itrNode.val = itrNode.next.val;
            prev = itrNode;
            itrNode = itrNode.next;
        }
        
        prev.next = null;
    }
}