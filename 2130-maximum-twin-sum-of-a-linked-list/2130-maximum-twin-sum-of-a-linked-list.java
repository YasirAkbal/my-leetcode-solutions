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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode left = head;
        ListNode right = reverseList(slow);
        
        int maxTwinSum = Integer.MIN_VALUE;
        while(right != null) {
            maxTwinSum = Math.max(maxTwinSum, left.val + right.val);
            
            left = left.next;
            right = right.next;
        }
        
        return maxTwinSum;
    }

    private static ListNode reverseList(ListNode head) {
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