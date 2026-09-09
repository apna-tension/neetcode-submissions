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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int pos = 1;
        ListNode last = null;
        ListNode temp = head;
        ListNode prev = null;
        ListNode lastRev = temp;
        while (pos <= right) {
            if (pos < left) {
                last = temp;
                temp = temp.next;
                lastRev = temp;
            } else {
                ListNode next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }
            pos++;
        }

        if (last != null) last.next = prev;
        else head = prev;
        lastRev.next = temp;
        return head;
    }
}