class Node {
    Node next;
    Node prev;
    int val;
    Node(int val) {
        next = null;
        prev = null;
        this.val = val;
    }
}
class MyCircularQueue {
    Node node;
    int n;
    Node temp;
    int size;
    public MyCircularQueue(int k) {
        node = null;
        temp = null;
        this.n = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (size == n) return false;
        Node currNode = new Node(value);
        if (node == null) {
            node = currNode;
            temp = node;
        } else {
            temp.next = currNode;
            currNode.prev = temp;
            temp = temp.next;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (node == null) return false;
        System.out.println(node.val);
        node = node.next;
        size--;
        if (size != 0) node.prev = null;
        return true;
    }
    
    public int Front() {
        if (size == 0) return -1;
        return node.val;
    }
    
    public int Rear() {
        if (size == 0) return -1;
        return temp.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == n;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */