class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : path.toCharArray()) {
            if (ch == '/' && sb.length() == 0) {
                continue;
            } else if (ch == '/') {
                if (sb.length() == 2 && sb.charAt(1) == '.' && sb.charAt(0) == '.') {
                    if (!stack.isEmpty()) stack.pop();
                } else if (sb.length() == 1 && sb.charAt(0) == '.') {
                    // System.out.println("Hit : " + stack + " : " + sb);
                    sb = new StringBuilder();
                    continue;

                }
                else {
                    stack.push(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        // System.out.println(stack + " : " + sb);
        }
        if ((sb.length() == 1 && sb.charAt(0) == '.') || sb.length() == 2 && sb.charAt(0) == '.' && sb.charAt(1) == '.') {
            if (sb.length() == 2) stack.pop();
            sb = new StringBuilder();
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()+"/");
        }
        sb.insert(0, "/");
        if (sb.length() != 1 && sb.charAt(sb.length()-1) == '/') sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}