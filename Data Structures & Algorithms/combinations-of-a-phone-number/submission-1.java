class Solution {
    public List<String> letterCombinations(String digits) {
        String[] digit = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        String[] req = new String[digits.length()];
        int i = 0;
        for (char ch : digits.toCharArray()) {
            req[i++] = digit[ch-'0'];
        }

        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        backtrack(0, digits.length(), req, new StringBuilder(), list);
        return list;        
    }

    private void backtrack(int i, int n, String[] digits, StringBuilder sb, List<String> list) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        if (i >= digits.length) return; 
        for (int j = i; j < digits.length; j++) {
            for (char ch : digits[j].toCharArray()) {
                sb.append(ch);
                backtrack(j+1, n, digits, sb, list);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
}
