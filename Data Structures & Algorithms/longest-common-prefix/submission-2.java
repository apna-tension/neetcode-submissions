class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prev = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prev = comp(prev, strs[i]);
        }
        return prev;
    }

    private String comp(String st1, String st2) {
        int i = 0, j = 0;
        while (i < st1.length() && j < st2.length() && st1.charAt(i) == st2.charAt(j)) {i++;j++;}
        return st1.substring(0, i);
    }
}