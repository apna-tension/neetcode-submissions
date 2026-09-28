class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> list = new HashSet<>();
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i++) {
        //     sb.append("()");
        // }
        // boolean visit[] = new boolean[n*2];

        // generate(n*2, 0, sb, list, new StringBuilder(), visit);

        // System.out.println(list);

        List<String> temp = new ArrayList<>();

        // for (String str : list) {
        //     if (isValid(str)) temp.add(str);
        // }
        backtrack(n, 0, 0, new StringBuilder(), temp);
        return temp;
    }

    private void backtrack(int n, int open, int close, StringBuilder sb, List<String> list) {
        if (open == n && close == n) {
            list.add(sb.toString());
            return;
        }
        if (open > n || close > open) return;

        if (open >= close) {
            sb.append('(');
            backtrack(n, open+1, close, sb, list);
            sb.delete(sb.length()-1, sb.length());
            if (open > close) {
                sb.append(')');
                backtrack(n, open, close+1, sb, list);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }

    private void generate(int n, int start, StringBuilder sb, Set<String> list, StringBuilder dummy, boolean[] visit) {
        if (dummy.length() == n) {
            list.add(dummy.toString());
            // System.out.println(list);
            return;
        }

        if (dummy.length() > 0 && dummy.charAt(0) == ')') return;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dummy.append(sb.charAt(i));
                generate(n, i+1, sb, list, dummy, visit);
                dummy.delete(dummy.length()-1, dummy.length());
                visit[i] = false;
            }
        }        
        
    }

    private boolean isValid(String sb) {
        int open = 0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '(') open++;
            else if (ch == ')') open--;
            
            if (open < 0) return false;
        }

        return open == 0;
    }
}
