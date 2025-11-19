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
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode tail = head;
        
        /*System.out.println("List1 = " + list1.val);
        System.out.println("List2 = " + list2.val);
        System.out.println("Tail = " + tail.val);*/
        
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else if(list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            } else {
                ListNode tempNode = list1.next;
                tail.next = list1;
                tail.next.next = list2;
                list1 = tempNode;
                list2 = list2.next;
                tail = tail.next.next;
            }
        }

        if(list1 != null) {
            tail.next = list1;
        }                   
        
        if(list2 != null) {
            tail.next = list2;
        }
        
        return head.next;
    }
}