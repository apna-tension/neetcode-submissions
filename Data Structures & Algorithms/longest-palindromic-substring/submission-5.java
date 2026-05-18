class Solution {
    public String longestPalindrome(String s) {
        String str = "" + s.charAt(0);
        int maxLen = 1;
        int start = 0;
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

            if (r - l - 1 > maxLen) {
                // str = s.substring(l+1, r);
                start = l+1;
                maxLen = r-l-1;
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

            if (r - l - 1 > maxLen) {
                // str = s.substring(l+1, r);
                start = l+1;
                maxLen = r-l-1;
            }


        }

        return s.substring(start, start+maxLen);
        
    }
}
