class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (ch == '[') {
                int num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                numStack.push(num);
                charStack.push("[");
                System.out.println(num);
            } else if (ch == ']') {
                String str = "";
                while (!charStack.peek().equals("[")) {
                    str = charStack.pop()+str;
                }
                charStack.pop();
                int n = numStack.pop();
                for (int i = 0; i < n; i++) {
                    charStack.push(str);
                }
            } else {
                charStack.push(ch + "");
            }
        }
        // System.out.println(charStack);
        // System.out.println(numStack);

        String ans = "";
        while (!charStack.isEmpty()) ans = charStack.pop() + ans;
        return ans;
    }
}