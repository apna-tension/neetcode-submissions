class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        min = new Stack<>();
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if (min.isEmpty() || min.peek() >= val) min.push(val);
    }
    
    public void pop() {
        int top = st.pop();
        if (top == min.peek() ) min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
