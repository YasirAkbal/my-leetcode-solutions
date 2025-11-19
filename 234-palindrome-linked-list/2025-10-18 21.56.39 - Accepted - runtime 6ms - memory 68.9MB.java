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
    public boolean isPalindrome(ListNode head) {        
        ListNode middle = getMiddle(head);
        ListNode rightHalfReversedHead = reverseList(middle);
        
        while(head != null && rightHalfReversedHead != null) {
            if(head.val != rightHalfReversedHead.val) {
                return false;
            }

            head = head.next;
            rightHalfReversedHead = rightHalfReversedHead.next;
        }
        
        return true;
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        
        while(head != null) {
            len++;
            head = head.next;
        }
        
        return len;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}