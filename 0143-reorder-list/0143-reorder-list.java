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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode left = head;
        ListNode right = reverseList(slow);
        
        ListNode dummy = new ListNode(0);
        dummy.next = left;
        
        ListNode itr = dummy;
        while(left != null && right != null) {
            ListNode leftNextTemp = left.next;
            ListNode rightNextTemp = right.next;
            
            itr.next = left;
            itr = itr.next;
            
            itr.next = right;
            itr = itr.next;
            
            left = leftNextTemp;
            right = rightNextTemp;
        }
        
        slow.next = null;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode itr = head;
        ListNode next;
        
        while(itr != null) {
            next = itr.next;
            itr.next = prev;
            prev = itr;
            itr = next;
        }
        
        return prev;
   }
}