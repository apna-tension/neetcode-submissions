/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> crsNode = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            crsNode.put(temp, new Node(temp.val));

            temp = temp.next;
        }

        Node dummy = new Node(0);
        Node helper = dummy;
        crsNode.put(null, null);
        Node hd = head;
        while (hd != null) {
            helper.next = crsNode.get(hd);
            helper = helper.next;
            helper.random = crsNode.get(hd.random);
            hd = hd.next;
        }        
        return dummy.next;
    }
}
