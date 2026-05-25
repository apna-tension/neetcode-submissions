class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String st : operations) {
            if (st.charAt(0) == 'C') {
                sum -= stack.pop();
            } else if (st.charAt(0) == 'D') {
                sum += stack.peek()*2;
                stack.push(stack.peek()*2);
            } else if (st.charAt(0) == '+') {
                int e1 = stack.pop();
                int e2 = stack.peek();
                int en = e1+e2;
                sum += en;
                stack.push(e1);
                stack.push(en);
            } else {
                stack.push(Integer.parseInt(st));
                sum += stack.peek();
            }
        }
        return sum;
    }
}