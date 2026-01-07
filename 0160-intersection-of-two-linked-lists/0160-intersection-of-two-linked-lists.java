/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itrA = headA;
        ListNode itrB = headB;
        
        while(itrA != itrB) {
            itrA = (itrA != null) ? itrA.next : headB;
            itrB = (itrB != null) ? itrB.next : headA;
        }
        
        return itrA;
    }
}