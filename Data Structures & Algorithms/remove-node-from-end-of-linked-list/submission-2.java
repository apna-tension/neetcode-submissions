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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            total++;
        }
        if (total - n == 0) return head.next;
        temp = head;
        for (int i = 1; i < total - n; i++) {
            temp = temp.next;
        }
        // if (temp.next == null) return head;
        temp.next = temp.next.next;
        return head;
    }
}
