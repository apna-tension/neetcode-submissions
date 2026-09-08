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
        Map<Node, Integer> nodeNumber = new HashMap<>();
        Map<Node, Node> crsNode = new HashMap<>();
        Map<Integer, Node> nodeGet = new HashMap<>();

        Node temp = head;
        int i = 0;
        while (temp != null) {
            nodeNumber.put(temp, i);
            Node copy = new Node(temp.val);
            crsNode.put(temp, copy);
            nodeGet.put(i, copy);

            i++;
            temp = temp.next;
        }

        Node dummy = new Node(0);
        Node helper = dummy;

        Node hd = head;
        while (hd != null) {
            int nodeNum = -1;
            if (hd.random != null) nodeNum = nodeNumber.get(hd.random);

            helper.next = crsNode.get(hd);
            helper = helper.next;
            if (nodeNum != -1) helper.random = nodeGet.get(nodeNum);
            else helper.random = null;
            hd = hd.next;
        }        
        return dummy.next;
    }
}
