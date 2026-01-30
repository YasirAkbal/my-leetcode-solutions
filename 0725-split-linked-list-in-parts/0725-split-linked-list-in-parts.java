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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        
        ListNode itr = head;
        while(itr != null) {
            len++;
            itr = itr.next;
        }
        
        int val = len <= k ? 1 : len / k;
        int mod = len <= k ? 0 : len % k;
        
        ListNode[] result = new ListNode[k];
        itr = head;
        int i = 0;
        
        while(itr != null) {
            int j = 0;
            result[i++] = itr;
            while(j < val - 1 + (mod > 0 ? 1 : 0)) {
                itr = itr.next;
                j++;
            }
            
            if(itr != null) {
                ListNode next = itr.next;
                itr.next = null;
                itr = next; 
            }
            
            mod--;
        }
        
        return result;
    }
}