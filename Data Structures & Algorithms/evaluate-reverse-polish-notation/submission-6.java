class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String st : tokens) {
            if (Character.isDigit(st.charAt(st.length()-1))) {
                stack.push(Integer.parseInt(st));
            } else {
                int right = stack.pop();
                int left = stack.pop();
                
                if (st.charAt(0) == '+') {
                    stack.push(left + right);
                } else if (st.charAt(0) == '-') {
                    stack.push(left - right);
                } else if (st.charAt(0) == '*') {
                    stack.push(left * right);
                } else {
                    stack.push(left / right);
                }
            } 
        }
        return stack.pop();
    }
}
