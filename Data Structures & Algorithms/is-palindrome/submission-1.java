class Solution {
    public boolean isPalindrome(String str) {
        int i = 0;
        String st = "";
        String s = str.toLowerCase();
        for (int k = 0; k < s.length(); k++) {
            if ((s.charAt(k) >= '0' && s.charAt(k) <= '9') || (s.charAt(k) >= 'a' && s.charAt(k) <= 'z')) st += s.charAt(k);
        }
        System.out.println(st);
        int j = st.length()-1;
        while (i < j) {
            if (st.charAt(i) != st.charAt(j)) return false;
            i++;
            j--;
        }

        
        return true;
    }
}
