class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prev = strs[0];
        if (strs.length == 1) return prev;
        String ans = "";
        for (int i = 1; i < strs.length; i++) {
            prev = comp(prev, strs[i]);
            ans = prev;
        }
        return ans;
    }

    private String comp(String st1, String st2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < st1.length() && j < st2.length() && st1.charAt(i) == st2.charAt(j)) {
            sb.append(st1.charAt(i));
            i++;j++;
        }
        return sb.toString();
    }
}