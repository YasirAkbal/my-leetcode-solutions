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
        int len = getLength(head);
        
        ListNode itr = head;
        int i = 0;
        while(i < len/2) {
            itr = itr.next;
            i++;
        }
        
        ListNode rightHalfReversedHead = reverseList(itr);
        
        i = 0;
        while(i < len/2) {
            if(head.val != rightHalfReversedHead.val) {
                return false;
            }
            head = head.next;
            rightHalfReversedHead = rightHalfReversedHead.next;
            i++;
        }
        
        //listeyi yeniden olustur
        
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