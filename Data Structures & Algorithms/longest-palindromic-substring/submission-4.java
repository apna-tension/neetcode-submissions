class Solution {
    public String longestPalindrome(String s) {
        String str = "" + s.charAt(0);
        for (int i = 0; i < s.length(); i++) {

            // for odd length palindrome
            int l = i-1; 
            int r = i+1;

            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else break;
            }

            if (r - l - 1 > str.length()) {
                str = s.substring(l+1, r);
            }

            // for even length palindrome
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else break;
            }

            if (r - l - 1 > str.length()) {
                str = s.substring(l+1, r);
            }


        }

        return str;
        
    }
}
