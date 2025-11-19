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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tail = null;
        
        if(list1.val < list2.val) {
            tail = list1;
            list1 = list1.next;
            tail.next = null;
        } else if(list1.val > list2.val) {
            tail = list2;
            list2 = list2.next;
            tail.next = null;  
        } else {
                
        }
        
        System.out.println("List1 = " + list1.val);
        System.out.println("List2 = " + list2.val);
        System.out.println("Tail = " + tail.val);
        
        /*while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                
            } else if(list1.val > list2.val) {
                
            } else {
                
            }
        }*/
        
        return null;
    }
}