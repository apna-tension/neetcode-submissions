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
        ListNode fast = head;
        ListNode slow = head;
        int cnt = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            cnt++;
        }
        fast = head;
        ListNode temp = null;
        // System.out.println("Middle : " + slow.val);
        // System.out.println("fast : " + fast.val);
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = temp;
            temp = slow;
            slow = next;
        }
        // System.out.println("fast : " + temp.val);

        // temp - revised 2nd half
        // fast - head;
        ListNode dummy = new ListNode(0);
        head = dummy;
        while (cnt --> 0) {
            head.next = fast;
            fast = fast.next;
            head.next.next = temp;
            temp = temp.next;
            head = head.next.next;
        }

        if (temp != null) {
            head.next = temp;
        }
        head = dummy.next;

        // while (head != null) {
        //     System.out.println(" " + head.val);
        //     head = head.next;
        // }
    }
}
