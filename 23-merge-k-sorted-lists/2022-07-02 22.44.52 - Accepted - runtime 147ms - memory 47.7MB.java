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

//https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/0
class Solution {
    ListNode merge2List(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;
        
        ListNode newHead = null;
        ListNode tail;
        if(head1.val < head2.val) {
            newHead = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            head2 = head2.next;
        }
        tail = newHead;
        
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        if(head1 != null) {
            tail.next = head1;
        } else if(head2 != null) {
            tail.next = head2;
        }
        
        return newHead;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        else if(lists.length == 1) return lists[0];
        ListNode merged = lists[0];
        
        for(int i=1;i<lists.length;i++) {
            merged = merge2List(merged,lists[i]);
        }
        
        return merged;
    }
    
    //Çözüm 2
    /*public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        else if(lists.length == 1) return lists[0];
        
        ListNode newHead;
        ListNode tail;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<lists.length;i++) {
            if(lists[i] != null && lists[i].val <= min) {
                min = lists[i].val;
                minIndex = i;
            }
        }
        
        if(minIndex == -1)
            return null;
        
        newHead = lists[minIndex];
        tail = newHead;
        lists[minIndex] = lists[minIndex].next;
        
        int count = 0;
        while(count != lists.length) {
            min = Integer.MAX_VALUE;
            minIndex = -1;
            for(int i=0;i<lists.length;i++) {
                if(lists[i] != null && lists[i].val <= min) {
                    min = lists[i].val;
                    minIndex = i;
                }
            }
            
            if(minIndex == -1)
                break;
            
            tail.next = lists[minIndex];
            tail = tail.next;
            lists[minIndex] = lists[minIndex].next;
            
            if(lists[minIndex] == null)
                count++;
        }
        
        
        return newHead;
    }*/
}