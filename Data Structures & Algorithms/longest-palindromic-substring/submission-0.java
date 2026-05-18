class Solution {
    public String longestPalindrome(String s) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String str = "";
            for (int j = i; j < s.length(); j++) {
                str += s.charAt(j);
                list.add(str);
            }
        }

        String str = "";
        for (String temp : list) {
            int ct = pal(temp);
            if (ct > str.length()) str = temp;
        }
        return str;
    }

    private int pal(String list) {
        int s = 0;
        int e = list.length()-1;
        while (s < e) {
            if (list.charAt(s) != list.charAt(e)) return -1;
            s++;
            e--;
        }
        return list.length();
    }
}
