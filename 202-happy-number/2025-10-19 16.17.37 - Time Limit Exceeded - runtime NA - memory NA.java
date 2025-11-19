class Solution {
    private class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
    public boolean isHappy(int n) {
        int i = 1;
        ListNode head = new ListNode(calculate(n));
        if(head.data == 1) { return true; }
    
        ListNode slow = head;
        ListNode fast = head;
        ListNode itr = head;

        do {
            itr.next = new ListNode(calculate(itr.data));
            itr = itr.next;

            if(i % 2 == 0) {
                slow = slow.next;
            }

            fast = itr;

            if(itr.data == 1) {
                return true;
            }
            i++;
            System.out.println(itr.data);
        } while(slow != fast);

        return false;
    }

    private int calculate(int number) {
        int result = 0;

        while(number > 0) {
            int lastDigit = number % 10;
            result += lastDigit * lastDigit;
            number /= 10;
        }

        return result;
    }
}