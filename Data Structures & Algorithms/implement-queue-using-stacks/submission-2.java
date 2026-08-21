class MyQueue {
    Stack<Integer> q;
    Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
        q = new Stack<>();
    }
    
    public void push(int x) {
        q.push(x);
    }
    
    public int pop() {
        if (stack.isEmpty()) {
            while (!q.isEmpty()) stack.push(q.pop());
        }
        return stack.pop();
    }
    
    public int peek() {
        if (stack.isEmpty()) {
            while (!q.isEmpty()) stack.push(q.pop());
        }
        return stack.peek();
    }
    
    public boolean empty() {
        return q.isEmpty() && stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */