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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        
        ListNode leftKth = fast;
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode rightKth = slow;
        
        swapNodeValues(leftKth, rightKth);
        
        return head;
    }

    private void swapNodeValues(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}