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
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null)
            slow = slow.next;
      
        while(slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        
        ListNode itr = head;
        ListNode next;
        ListNode popped;
        while(!stack.isEmpty()) {
            next = itr.next;
            popped = stack.pop();
            
            itr.next = popped;
            popped.next = next;
            itr = next;
        }
        
        itr.next = null;
    }
}